package com.kuzal.kuzalcompetition.service;

import com.kuzal.kuzalcompetition.model.Reply;
import com.kuzal.kuzalcompetition.repository.ReplyRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ReplyServiceImpl implements ReplyService {

    Logger logger = LoggerFactory.getLogger(ReplyServiceImpl.class);

    @Autowired
    private ReplyRepository replyRepository;

    @Override
    public List<Reply> getReplyList(String videoId) {
        List<Reply> result =  replyRepository.findByVideoId(videoId);
        for(Reply reply : result ) {
            System.out.println(reply.getUserId());
        }
        return result;
    }

    @Override
    public List<Reply> insertReply(Reply reply) {
        logger.info("insertReply");
        replyRepository.insert(reply);

        return replyRepository.findByVideoId(reply.getVideoId());
    }

    @Override
    public void updateReply() {

    }

    @Override
    public void deleteReply(String id) {
        replyRepository.deleteById(id);
    }
}
