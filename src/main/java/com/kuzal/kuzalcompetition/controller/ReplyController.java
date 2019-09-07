package com.kuzal.kuzalcompetition.controller;

import com.kuzal.kuzalcompetition.model.Reply;
import com.kuzal.kuzalcompetition.service.ReplyService;
import com.kuzal.kuzalcompetition.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/replys")
public class ReplyController {

    Logger logger = LoggerFactory.getLogger(ReplyController.class);

    @Autowired
    private ReplyService replyService;

    @GetMapping("/get/{id}")
    List<Reply> getReplyList(@PathVariable("id") String videoId) {
        return replyService.getReplyList(videoId);
    }
    @PostMapping("/add")
    List<Reply> insertReply(@RequestBody Reply reply) {
        return replyService.insertReply(reply);
    }
    @PostMapping("/update")
    void updateReply(@RequestBody Reply reply) {
        replyService.updateReply();
    }
    @PostMapping("/delete")
    void deleteReply(@RequestBody String id) {
        replyService.deleteReply(id);
    }
}
