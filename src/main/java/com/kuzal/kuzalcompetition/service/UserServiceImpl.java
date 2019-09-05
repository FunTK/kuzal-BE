package com.kuzal.kuzalcompetition.service;

import com.kuzal.kuzalcompetition.model.User;
import com.kuzal.kuzalcompetition.repository.UserRepository;
import com.kuzal.kuzalcompetition.repository.VideoRepository;
import com.kuzal.kuzalcompetition.request.UserLoginRequest;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public User findUserByEmailAddress(UserLoginRequest request) {
        User user = userRepository.getUserByEmailAddress(request.getEmail());

        if (user == null) {
            user = saveUser(request);
        }

        return user;
    }

    private User saveUser(UserLoginRequest request) {
        User user = User.builder().emailAddress(request.getEmail()).nickName(request.getDisplayName()).regDate(new Date()).build();
        user = userRepository.save(user);
        return user;
    }

    @Override
    public UpdateResult updateUserByEmailAddress(String emailAddress, String nickName) {
        return userRepository.updateUserByEmailAddress(emailAddress, nickName);
    }

    @Override
    public User getUserByEmailAddress(String emailAddress) {
        return userRepository.getUserByEmailAddress(emailAddress);
    }

    @Override
    public boolean deleteUserByUserId(String userId) {
        //todo delete video , delete comment, delete user

        if (videoRepository.deleteVideoByUserId(userId).getDeletedCount() != 1) {
            log.error("can not delete user [{}]", userId);
            return false;
        }

        if (userRepository.deleteUserByUserId(userId).getDeletedCount() != 1) {
            log.error("can not delete user [{}]", userId);
            return false;
        }
        return true;
    }
}
