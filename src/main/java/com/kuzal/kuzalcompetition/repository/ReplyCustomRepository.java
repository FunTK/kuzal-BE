package com.kuzal.kuzalcompetition.repository;

import java.util.List;

public interface ReplyCustomRepository {
    List findByVideoId(String videoId);
}
