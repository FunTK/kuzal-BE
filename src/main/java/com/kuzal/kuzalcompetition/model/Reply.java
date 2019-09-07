package com.kuzal.kuzalcompetition.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "reply")
public class Reply {
    @Id
    private String _id;
    private String userId;
    private String videoId;
    private String comment;
    private String regDate;
}
