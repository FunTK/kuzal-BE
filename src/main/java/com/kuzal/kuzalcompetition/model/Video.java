package com.kuzal.kuzalcompetition.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "video")
public class Video {
    @Id
    private String _id;
    private String userId;
    private String title;
    private String url;
    private String catId;
    private String thumbnailUrl;
    private String description;
    private String regDate;
    private Integer views;
}
