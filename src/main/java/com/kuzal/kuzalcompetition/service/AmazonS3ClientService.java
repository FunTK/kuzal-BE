package com.kuzal.kuzalcompetition.service;

import org.springframework.web.multipart.MultipartFile;

public interface AmazonS3ClientService {
    void uploadFileToS3Bucket(MultipartFile multipartFile, boolean enablePublicReadAccess);
}
