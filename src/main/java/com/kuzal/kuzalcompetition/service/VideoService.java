package com.kuzal.kuzalcompetition.service;

import com.kuzal.kuzalcompetition.model.Video;

import java.util.List;
import java.util.Optional;


public interface VideoService {
     List<Video> getVideoList();
    List<Video> getVideoList(String userId);

    Optional<Video> getVideo(String id);

    Video insertVideo(Video video);


    Optional<Video> updateVideo(Video video);

    Optional<Video> updateVideoViews(Video video);
}
