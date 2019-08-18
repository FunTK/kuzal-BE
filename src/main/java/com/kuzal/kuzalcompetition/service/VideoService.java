package com.kuzal.kuzalcompetition.service;

import com.kuzal.kuzalcompetition.model.Video;


import java.util.List;
import java.util.Optional;


public interface VideoService {
    List<Video> getVideoList();

    Optional<Video> getVideo(String id);

    Video insertVideo(Video video);

}
