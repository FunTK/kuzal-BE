package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.Like;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LikedRepository extends  MongoRepository<Like, String>, LikedCustomRepository {
}
