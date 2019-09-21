package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.Video;
import com.mongodb.client.result.DeleteResult;

import java.util.List;

public interface VideoCustomRepository {
    List<Video> findAll();
    List<Video> findByCatId(String catId);
    List<Video> findByUserId(String userId);
    Video saveVideo(Video video);
    Video updateById(Video video);
    DeleteResult deleteVideoByUserId(String userId);
    void updateViewsById(Video video);
}
