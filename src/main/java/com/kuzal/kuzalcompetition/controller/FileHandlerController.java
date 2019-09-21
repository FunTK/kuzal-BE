package com.kuzal.kuzalcompetition.controller;

import com.kuzal.kuzalcompetition.service.AmazonS3ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/files")
public class FileHandlerController {


    @Autowired
    private AmazonS3ClientService amazonS3ClientService;

    @CrossOrigin("*")
    @RequestMapping(value = "/upload", headers = ("content-type=multipart/form-data"), method = RequestMethod.POST)
    public Map<String, String> uploadFile(@RequestPart(value = "file") MultipartFile file)
    {
        this.amazonS3ClientService.uploadFileToS3Bucket(file, "video/" , true);
        Map<String, String> response = new HashMap<>();
        response.put("message", "file [" + file.getOriginalFilename() + "] uploading request submitted successfully.");
        return response;
    }


    @GetMapping
    public String getFileUrl()
    {
        String fileUrl = this.amazonS3ClientService.selectFileUrl("video", "test.png");
        return fileUrl;
    }

}
