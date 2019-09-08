package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.Like;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import static com.kuzal.kuzalcompetition.model.QLike.like;
import static com.kuzal.kuzalcompetition.util.MongoQueryUtil.parse;


@Slf4j
public class LikedCustormRepositoryImpl implements LikedCustomRepository {

    Logger logger = LoggerFactory.getLogger(LikedCustormRepositoryImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Long countByVideoId(String videoId) {
        Query query = new Query();
        query.addCriteria(Criteria.where(parse(like.videoId)).is(videoId));
        Long count = mongoTemplate.count(query, Integer.class);
        return count;
    }

    @Override
    public Like findLikeByVideoId(Like liked) {
        logger.info(liked.getVideoId());
        logger.info(liked.getUserId());
        Query query = new Query();
        query.addCriteria(Criteria.where(parse(like.videoId)).is(liked.getVideoId()));
        query.addCriteria(Criteria.where(parse(like.userId)).is(liked.getUserId()));
        return mongoTemplate.findOne(query, Like.class);
    }
}
