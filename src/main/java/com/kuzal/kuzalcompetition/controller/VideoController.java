package com.kuzal.kuzalcompetition.controller;


import com.kuzal.kuzalcompetition.model.Video;
import com.kuzal.kuzalcompetition.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping(method = RequestMethod.GET)
    List<Video> getVideos(){
        return videoService.getVideoList();
    }

    @GetMapping("/{id}")
    Optional<Video> getVideo(@PathVariable("id") String id) {
        return videoService.getVideo(id);
    }

}
