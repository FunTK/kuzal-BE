package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>, UserCustomRepository {
}
