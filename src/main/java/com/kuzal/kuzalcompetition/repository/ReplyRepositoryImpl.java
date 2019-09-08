package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;


import static com.kuzal.kuzalcompetition.model.QReply.reply;
import static com.kuzal.kuzalcompetition.util.MongoQueryUtil.parse;

public class ReplyRepositoryImpl implements ReplyCustomRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Reply> findByVideoId(String videoId) {
        Query query = new Query();
        query.addCriteria(Criteria.where(parse(reply.videoId)).is(videoId));
        query.with(new Sort(Sort.Direction.DESC, parse(reply.regDate)));
        List<Reply> replyList = mongoTemplate.find(query, Reply.class);
        return replyList;
    }
}
