package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.Video;

import java.util.List;

public interface VideoCustomRepository {
    List<Video> findAll();
    Video findByTitle(String name);
    Video saveVideo(Video video);
    Video updateById(Video video);
}
