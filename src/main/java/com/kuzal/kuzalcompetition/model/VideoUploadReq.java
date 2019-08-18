package com.kuzal.kuzalcompetition.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;


@Data
@Document(collection = "video")
public class VideoUploadReq {
    @Id
    private String id;
    private String userId;
    private String title;
    private String url;
    private String catId;
    private String thumnailUrl;
    private String regDate;
    private Integer views;
    private String description;
    private MultipartFile videoFile;
    private MultipartFile thumnailFile;
}
