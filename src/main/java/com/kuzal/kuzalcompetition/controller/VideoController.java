package com.kuzal.kuzalcompetition.controller;


import com.kuzal.kuzalcompetition.model.Video;
import com.kuzal.kuzalcompetition.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping(method = RequestMethod.GET)
    List<Video> getVideos(){
        return videoService.getVideoList();
    }

}
