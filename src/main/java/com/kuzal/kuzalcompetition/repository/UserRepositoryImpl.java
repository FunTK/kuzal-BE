package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.QUser;
import com.kuzal.kuzalcompetition.model.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

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

    @Override
    public UpdateResult updateUserByEmailAddress(String emailAddress, String nickName){
        Query query = new Query();
        query.addCriteria(Criteria.where(parse(QUser.user.emailAddress)).is(emailAddress));
        Update update = new Update();
        update.set(parse(QUser.user.nickName),nickName);

        return mongoTemplate.updateFirst(query,update,User.class);
    }

    @Override
    public DeleteResult deleteUserByUserId(String userId){
        Query query = new Query();
        query.addCriteria(Criteria.where(parse(QUser.user.id)).is(userId));

        return mongoTemplate.remove(query,User.class);
    }

}
