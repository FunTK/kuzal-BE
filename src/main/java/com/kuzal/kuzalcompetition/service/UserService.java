package com.kuzal.kuzalcompetition.service;

import com.kuzal.kuzalcompetition.model.User;
import com.kuzal.kuzalcompetition.request.UserLoginRequest;
import com.mongodb.client.result.UpdateResult;

public interface UserService {
    User findUserByEmailAddress(UserLoginRequest emailAddress);
    UpdateResult updateUserByEmailAddress(String emailAddress, String nickName);
    User getUserByEmailAddress(String emailAddress);
    boolean deleteUserByUserId(String emailAddress);
}
