package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends  MongoRepository<Category, String>, CategoryCustomRepository {
}
