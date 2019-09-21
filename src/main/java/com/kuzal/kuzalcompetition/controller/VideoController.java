package com.kuzal.kuzalcompetition.controller;


import com.kuzal.kuzalcompetition.model.Like;
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
    List<Video> getVideoList() {
        return videoService.getVideoList();
    }

    @GetMapping("/my/{userId}")
    List<Video> getMyVideoList(@PathVariable("userId") String userId) {
        return videoService.getVideoList(userId);
    }

    @GetMapping("/category/{catId}")
    List<Video> getVideosByCategory(@PathVariable("catId") String catId) {
        return videoService.getVideoListByCatId(catId);
    }

    @GetMapping("/get/{id}")
    Optional<Video> getVideo(@PathVariable("id") String id) {
        return videoService.getVideo(id);
    }


    @PostMapping("/update")
    Optional<Video> updateVideo(@RequestBody Video video) {
        return videoService.updateVideo(video);
    }

    @PostMapping("/views")
    Optional<Video> updateVideoViews(@RequestBody Video video) {
        return videoService.updateVideoViews(video);
    }

    @PostMapping("/myLiked")
    Like getVideoMyLiked(@RequestBody Like liked) { return videoService.getVideoMyLiked(liked); }
    @GetMapping("/liked/{id}")
    Long getVideoLiked(@PathVariable("id") String videoId) { return videoService.getVideoLiked(videoId); }
    @PostMapping("/liked")
    void updateVideoLiked(@RequestBody Like liked) { videoService.updateVideoLiked(liked); }
    /**
     * video upload
     *
     * @param videoReq
     * @return
     */
    //@PostMapping("/upload")
    @RequestMapping(value = "/upload", headers = ("content-type=multipart/form-data"), method = RequestMethod.POST)
    Map<String, String> uploadVideo(@ModelAttribute VideoUploadReq videoReq) {
        Map<String, String> result = new HashMap<String, String>();
        // video, thumnail check
        if (videoReq.getVideoFile() == null || videoReq.getThumbnailFile() == null) {
            result.put("result", "Bad request");
            return result;
        }

        Video video = new Video();
        video.setTitle(videoReq.getTitle());
        video.setRegDate(videoReq.getRegDate());
        video.setDescription(videoReq.getDescription());
        video.setUserId(videoReq.getUserId());
        video.setCatId(videoReq.getCatId());

        // video upload
        amazonS3ClientService.uploadFileToS3Bucket(videoReq.getVideoFile(), "video/", true);

        String videoUrl = this.amazonS3ClientService.selectFileUrl("video", videoReq.getVideoFile().getOriginalFilename());
        video.setUrl(videoUrl);

        // video data insert
        System.out.println("video url : " + videoUrl);

        // thumnail upload
        amazonS3ClientService.uploadFileToS3Bucket(videoReq.getThumbnailFile(), "thumnail/", true);

        String thumbnailUrl = this.amazonS3ClientService.selectFileUrl("thumnail", videoReq.getThumbnailFile().getOriginalFilename());
        video.setThumbnailUrl(thumbnailUrl);
        System.out.println("thumnail url : " + thumbnailUrl);

        // mongodb insert
        videoService.insertVideo(video);
        result.put("result", "Success");
        return result;
    }

}
