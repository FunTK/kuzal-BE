package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.Video;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

import static com.kuzal.kuzalcompetition.model.QVideo.video;
import static com.kuzal.kuzalcompetition.util.MongoQueryUtil.parse;

@Slf4j
public class VideoRepositoryImpl  implements VideoCustomRepository {

    Logger logger = LoggerFactory.getLogger(VideoRepositoryImpl.class);

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

    @Override
    public Video saveVideo(Video video) {
        return mongoTemplate.insert(video);
    }

    @Override
    public Video updateById(Video updateVideo) {
        logger.info("updateById"+updateVideo.get_id());
        Query query = new Query();
        query.addCriteria(Criteria.where(parse(video._id)).is(new ObjectId(updateVideo.get_id())));
        Update update = new Update();
        update.set(parse(video.title), updateVideo.getTitle());
        update.set(parse(video.description), updateVideo.getDescription());
        mongoTemplate.updateFirst(query, update, "video");

        return updateVideo;
    }

}
