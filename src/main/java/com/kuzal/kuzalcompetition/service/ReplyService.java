package com.kuzal.kuzalcompetition.service;

import com.kuzal.kuzalcompetition.model.Reply;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReplyService {
    List<Reply> getReplyList(String videoId);

    List<Reply> insertReply(Reply reply);

    void updateReply();

    void deleteReply(String id);
}
