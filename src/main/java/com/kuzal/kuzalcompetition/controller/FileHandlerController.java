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
        System.out.println("start file upload");
        System.out.println(file);

        this.amazonS3ClientService.uploadFileToS3Bucket(file, true);

        Map<String, String> response = new HashMap<>();
        response.put("message", "file [" + file.getOriginalFilename() + "] uploading request submitted successfully.");
        response.put("test", "test");
        return response;
    }


    @GetMapping
    public String getFileUrl()
    {
        System.out.println("start get file");

        //String response = "success";

        String fileUrl = this.amazonS3ClientService.selectFileUrl("test.png");


        return fileUrl;
    }

}
