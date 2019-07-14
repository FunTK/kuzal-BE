package com.kuzal.kuzalcompetition.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "video")
public class Video {
    @Id
    private String id;
    private String title;
    private String url;
    private String thumnail;
    private String regDate;
}
