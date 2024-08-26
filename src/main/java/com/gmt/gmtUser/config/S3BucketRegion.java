package com.gmt.gmtUser.config;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetBucketLocationRequest;
import software.amazon.awssdk.services.s3.model.GetBucketLocationResponse;

public class S3BucketRegion {

    public static void main(String[] args) {
        String bucketName = "gmt-place-poi-images";

        // The region here can be any as it will be redirected to the correct one based on the bucket location
        S3Client s3 = S3Client.builder()
                .region(Region.AP_SOUTHEAST_2)
                .build();

        GetBucketLocationRequest locationRequest = GetBucketLocationRequest.builder()
                .bucket(bucketName)
                .build();

        GetBucketLocationResponse locationResponse = s3.getBucketLocation(locationRequest);
        Region region = locationResponse.locationConstraintAsString() == null ? Region.US_EAST_1 : Region.of(locationResponse.locationConstraintAsString());

        System.out.println("Bucket region: " + region.id());
    }
}
