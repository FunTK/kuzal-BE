package com.kuzal.kuzalcompetition.controller;


import com.kuzal.kuzalcompetition.model.Video;
import com.kuzal.kuzalcompetition.model.VideoUploadReq;
import com.kuzal.kuzalcompetition.service.AmazonS3ClientService;
import com.kuzal.kuzalcompetition.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class VideoController {

    Logger logger = LoggerFactory.getLogger(VideoController.class);

    @Autowired
    private VideoService videoService;

    @Autowired
    private AmazonS3ClientService amazonS3ClientService;

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
    /**
     * video upload
     * @param videoReq
     * @return
     */
    //@PostMapping("/upload")

    @RequestMapping(value = "/upload", headers = ("content-type=multipart/form-data"), method = RequestMethod.POST)
    Map<String, String> uploadVideo(@ModelAttribute VideoUploadReq videoReq){
        Map<String, String> result = new HashMap<String, String>();
        // video, thumnail check
        if(videoReq.getVideoFile() == null || videoReq.getThumnailFile() == null){
            result.put("result", "Bad request");
            return result;
        }

        Video video = new Video();
        video.setTitle(videoReq.getTitle());
        video.setRegDate(videoReq.getRegDate());
        video.setDescription(videoReq.getDescription());
        video.setUserId(videoReq.getUserId());

        // video upload
        amazonS3ClientService.uploadFileToS3Bucket(videoReq.getVideoFile(), "video/", true);

        String videoUrl = this.amazonS3ClientService.selectFileUrl(videoReq.getVideoFile().getOriginalFilename());
        video.setUrl(videoUrl);

        // video data insert
        System.out.println("video url : " + videoUrl);

        // thumnail upload
        amazonS3ClientService.uploadFileToS3Bucket(videoReq.getThumnailFile(), "thumnail/", true);

        String thumnailUrl = this.amazonS3ClientService.selectFileUrl(videoReq.getThumnailFile().getOriginalFilename());
        video.setThumnailUrl(thumnailUrl);
        System.out.println("thumnail url : " + thumnailUrl);

        // mongodb insert
        videoService.insertVideo(video);
        result.put("result", "Success");
        return result;
    }

}
