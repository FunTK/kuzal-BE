package com.kuzal.kuzalcompetition.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class VideoUploadReq {

    private String userId;
    private String title;
    private String url;
    private String catId;
    private String thumnailUrl;
    private String regDate;
    private String description;
    private MultipartFile videoFile;
    private MultipartFile thumnailFile;
}
