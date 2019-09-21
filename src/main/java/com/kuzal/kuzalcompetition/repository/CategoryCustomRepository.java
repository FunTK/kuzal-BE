package com.kuzal.kuzalcompetition.repository;



import com.kuzal.kuzalcompetition.model.Category;

import java.util.List;

public interface CategoryCustomRepository {

    // 카테고리 전체 목록 조회
    List<Category> findAll();
}
