package com.kuzal.kuzalcompetition.service;

import com.kuzal.kuzalcompetition.model.User;
import com.kuzal.kuzalcompetition.request.UserLoginRequest;

public interface UserService {
    User findUserByEmailAddress(UserLoginRequest emailAddress);
}
