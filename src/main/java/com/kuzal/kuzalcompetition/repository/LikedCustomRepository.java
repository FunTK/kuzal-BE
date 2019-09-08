package com.kuzal.kuzalcompetition.repository;

import com.kuzal.kuzalcompetition.model.Like;

public interface LikedCustomRepository {
    Long countByVideoId(String videoId);

    Like findLikeByVideoId(Like liked);
}
