package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public interface UserCustomRepository {
    User getUserByEmailAddress(String emailAddress);
    UpdateResult updateUserByEmailAddress(String emailAddress, String nickName);
    DeleteResult deleteUserByUserId(String userId);
}
