package com.gmt.gmtUser.controller;

import com.gmt.gmtUser.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/s3")
public class S3Controller {

    @Autowired
    private S3Service s3Service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("key") String key) {

        try {
            File tempFile = File.createTempFile("temp", file.getOriginalFilename());
            file.transferTo(tempFile);
            s3Service.uploadFile(key, tempFile);
            tempFile.delete();
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully: " + key);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file: " + e.getMessage());
        }
    }

    @GetMapping("/download")
    public ResponseEntity<String> downloadFile(
            @RequestParam("key") String key,
            @RequestParam("downloadFilePath") String downloadFilePath) {

        try {
            s3Service.downloadFile(key, downloadFilePath);
            return ResponseEntity.status(HttpStatus.OK).body("File downloaded successfully: " + key);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error downloading file: " + e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<String>> listFiles() {
        List<String> files = s3Service.listFiles();
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFile(@RequestParam("key") String key) {
        try {
            s3Service.deleteFile(key);
            return ResponseEntity.status(HttpStatus.OK).body("File deleted successfully: " + key);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting file: " + e.getMessage());
        }
    }

    @PostMapping("/uploadFolder")
    public ResponseEntity<String> uploadFolder(
            @RequestParam("folderPath") String folderPath) {

        try {
            s3Service.uploadFolder(folderPath);
            return ResponseEntity.status(HttpStatus.OK).body("Folder uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading folder: " + e.getMessage());
        }
    }
}
