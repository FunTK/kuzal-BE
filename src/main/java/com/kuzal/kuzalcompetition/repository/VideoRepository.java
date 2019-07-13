package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface VideoRepository extends MongoRepository<Video,String>, QuerydslPredicateExecutor<Video>, VideoCustomRepository {
}
