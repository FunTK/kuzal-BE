package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;


@Slf4j
public class CategoryCustormRepositoryImpl implements CategoryCustomRepository {

    Logger logger = LoggerFactory.getLogger(CategoryCustormRepositoryImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<Category> findAll() {
        return mongoTemplate.findAll(Category.class);
    }
}
