package com.kuzal.kuzalcompetition.service;

import com.kuzal.kuzalcompetition.model.User;
import com.kuzal.kuzalcompetition.repository.UserRepository;
import com.kuzal.kuzalcompetition.request.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByEmailAddress(UserLoginRequest request){
        User user = userRepository.getUserByEmailAddress(request.getEmail());

        if(user == null){
            user = saveUser(request);
        }

        return user;
    }

    private User saveUser(UserLoginRequest request){
        User user = User.builder().emailAddress(request.getEmail()).nickName(request.getDisplayName()).regDate(new Date()).build();
        user = userRepository.save(user);
        return user;
    }
}
