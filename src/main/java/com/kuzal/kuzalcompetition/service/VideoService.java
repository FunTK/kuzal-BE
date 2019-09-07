package com.kuzal.kuzalcompetition.service;

import com.kuzal.kuzalcompetition.model.Reply;
import com.kuzal.kuzalcompetition.model.Video;


import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface VideoService {
     List<Video> getVideoList();

    Optional<Video> getVideo(String id);

    Video insertVideo(Video video);


    Optional<Video> updateVideo(Video video);

    Optional<Video> updateVideoViews(Video video);
}
