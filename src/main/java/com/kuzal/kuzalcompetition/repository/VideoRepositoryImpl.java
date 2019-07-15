package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.Video;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static com.kuzal.kuzalcompetition.model.QVideo.video;
import static com.kuzal.kuzalcompetition.util.MongoQueryUtil.parse;

@Slf4j
public class VideoRepositoryImpl  implements VideoCustomRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Video> findAll(){
        return mongoTemplate.findAll(Video.class);
    }


    // for reference
    @Override
    public Video findByTitle(String name){
        Query query = new Query();
        query.addCriteria(Criteria.where(parse(video.title)).is(name));
        return mongoTemplate.findOne(query,Video.class);
    }

}
