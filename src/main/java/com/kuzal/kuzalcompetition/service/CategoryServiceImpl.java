package com.kuzal.kuzalcompetition.service;

import com.kuzal.kuzalcompetition.model.Category;
import com.kuzal.kuzalcompetition.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategorys() {
        return categoryRepository.findAll();
    }
}
