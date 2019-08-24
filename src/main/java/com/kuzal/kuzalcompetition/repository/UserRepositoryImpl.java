package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.QUser;
import com.kuzal.kuzalcompetition.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import static com.kuzal.kuzalcompetition.util.MongoQueryUtil.parse;


public class UserRepositoryImpl implements UserCustomRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User getUserByEmailAddress(String emailAddress) {
        Query query = new Query();
        query.addCriteria(Criteria.where(parse(QUser.user.emailAddress)).is(emailAddress));
        return mongoTemplate.findOne(query,User.class);
    }


}
