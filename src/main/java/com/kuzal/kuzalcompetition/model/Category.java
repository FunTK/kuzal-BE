package com.kuzal.kuzalcompetition.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "category")
public class Category {
    @Id
    private String id;
    private String title;
    private String catId;
    private boolean visible;
    private String startDate;
    private String finishDate;

}
