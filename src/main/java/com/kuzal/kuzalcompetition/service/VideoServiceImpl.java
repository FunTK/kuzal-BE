package com.kuzal.kuzalcompetition.service;

import com.kuzal.kuzalcompetition.model.Video;
import com.kuzal.kuzalcompetition.repository.VideoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getVideoList(){
        List<Video> videoList = videoRepository.findAll();
        return videoList;
    }

    @Override
    public Optional<Video> getVideo(String id) {
        Optional<Video> video = videoRepository.findById(id);
        return video;
    }

    @Override
    public Optional<Video> updateVideo(Video video) {
        Video upVideo = videoRepository.updateById(video);
        return null;
    }
}
