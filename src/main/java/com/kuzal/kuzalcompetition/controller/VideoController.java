package com.kuzal.kuzalcompetition.controller;


import com.kuzal.kuzalcompetition.model.Video;
import com.kuzal.kuzalcompetition.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class VideoController {

    Logger logger = LoggerFactory.getLogger(VideoController.class);

    @Autowired
    private VideoService videoService;

    @GetMapping
    List<Video> getVideoList(){
        return videoService.getVideoList();
    }

    @GetMapping("/get/{id}")
    Optional<Video> getVideo(@PathVariable("id") String id) {
        return videoService.getVideo(id);
    }


    @PostMapping("/update")
    Optional<Video> updateVideo(@RequestBody Video video) {
        return videoService.updateVideo(video);
    }
}
