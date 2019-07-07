package com.kuzal.kuzalcompetition.service;

import com.kuzal.kuzalcompetition.model.Video;
import com.kuzal.kuzalcompetition.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getVideoList(){
        List<Video> videoList = videoRepository.findAll();
        return videoList;
    }
}
