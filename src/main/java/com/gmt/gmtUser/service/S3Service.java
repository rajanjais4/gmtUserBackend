package com.gmt.gmtUser.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class S3Service {

    private final S3Client s3Client;
    private final String bucketName;

    public S3Service(S3Client s3Client, @Value("${aws.s3.bucketName}") String bucketName) {
        this.s3Client = s3Client;
        this.bucketName = bucketName;
    }

    public void uploadFile(String key, File file) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromFile(file));
    }

    public void downloadFile(String key, String downloadFilePath) throws IOException {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        ResponseInputStream<GetObjectResponse> s3Object = s3Client.getObject(getObjectRequest);
        File file = new File(downloadFilePath);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] readBuffer = new byte[4096];
            int readLength;
            while ((readLength = s3Object.read(readBuffer)) > 0) {
                fos.write(readBuffer, 0, readLength);
            }
        }
    }

    public List<String> listFiles() {
        ListObjectsV2Request listObjectsV2Request = ListObjectsV2Request.builder()
                .bucket(bucketName)
                .build();

        ListObjectsV2Response listObjectsV2Response = s3Client.listObjectsV2(listObjectsV2Request);
        return listObjectsV2Response.contents().stream()
                .map(S3Object::key)
                .collect(Collectors.toList());
    }

    public void uploadFolder(String folderPath) throws IOException {
        Path folder = Paths.get(folderPath);
        if (!Files.exists(folder)) {
            throw new IOException("Folder not found: " + folderPath);
        }

        try (Stream<Path> paths = Files.walk(folder)) {
            Runnable
            paths.filter(Files::isRegularFile).forEach(filePath -> {
                try {
                    String key = folder.relativize(filePath).toString().replace("\\", "/");
                    uploadFile(key, filePath.toFile());
                } catch (Exception e) {
                    throw new RuntimeException("Failed to upload file: " + filePath.toString(), e);
                }
            });
        }
    }

    public void deleteFile(String key) {
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        s3Client.deleteObject(deleteObjectRequest);
    }
}
