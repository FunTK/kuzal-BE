package com.kuzal.kuzalcompetition.service;

import com.kuzal.kuzalcompetition.model.Like;
import com.kuzal.kuzalcompetition.model.Video;
import com.kuzal.kuzalcompetition.repository.LikedRepository;
import com.kuzal.kuzalcompetition.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private LikedRepository likeRepository;

    public List<Video> getVideoList(){
        List<Video> videoList = videoRepository.findAll();
        return videoList;
    }

    @Override
    public List<Video> getVideoList(String userId) {
        System.out.println("userId: " + userId);
        List<Video> videoList = videoRepository.findByUserId(userId);
        return videoList;
    }

    @Override
    public Optional<Video> getVideo(String id) {
        Optional<Video> video = videoRepository.findById(id);
        return video;
    }

    @Override
    public Video insertVideo(Video video) {
        return videoRepository.saveVideo(video);
    }

    @Override
    public Optional<Video> updateVideo(Video video) {
        Video upVideo = videoRepository.updateById(video);
        return null;
    }

    @Override
    public Optional<Video> updateVideoViews(Video video) {
        videoRepository.updateViewsById(video);
        return null;
    }

    @Override
    public void updateVideoLiked(Like liked) {
        likeRepository.insert(liked);
    }

    @Override
    public Long getVideoLiked(String videoId) {
        return likeRepository.countByVideoId(videoId);
    }

    @Override
    public Like getVideoMyLiked(Like liked) {
        return likeRepository.findLikeByVideoId(liked);
    }
}
