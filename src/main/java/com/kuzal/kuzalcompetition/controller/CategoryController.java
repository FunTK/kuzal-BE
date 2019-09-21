package com.kuzal.kuzalcompetition.controller;


import com.kuzal.kuzalcompetition.model.Category;
import com.kuzal.kuzalcompetition.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorys")
public class CategoryController {

    Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    // 카테고리 목록 조회
    @GetMapping
    List<Category> getCategorys() {
        return categoryService.getCategorys();
    }



}
