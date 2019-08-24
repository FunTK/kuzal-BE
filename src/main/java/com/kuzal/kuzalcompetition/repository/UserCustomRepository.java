package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.User;

public interface UserCustomRepository {
    User getUserByEmailAddress(String emailAddress);
}
