package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class VideoRepositoryImpl  implements VideoCustomRepository {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<Video> findAll(){
        return mongoTemplate.findAll(Video.class);
    }

}
