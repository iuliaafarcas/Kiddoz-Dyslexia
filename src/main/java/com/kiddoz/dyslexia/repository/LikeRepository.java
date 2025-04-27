package com.kiddoz.dyslexia.repository;

import com.kiddoz.dyslexia.model.LikeEntity;
import com.kiddoz.dyslexia.model.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeEntity, LikeId> {

    // Check if the user already liked the post
    boolean existsByIdUserIdAndIdPostId(Long userId, Long postId);
}