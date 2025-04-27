package com.kiddoz.dyslexia.service;


import com.kiddoz.dyslexia.model.LikeEntity;
import com.kiddoz.dyslexia.model.LikeId;
import com.kiddoz.dyslexia.repository.LikeRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    // Add a like
    public LikeEntity addLike(Long userId, Long postId) {
        if (likeRepository.existsByIdUserIdAndIdPostId(userId, postId)) {
            throw new IllegalStateException("User already liked this post");
        }

        LikeEntity like = new LikeEntity();
        like.setId(new LikeId(userId, postId)); // Set composite id
        return likeRepository.save(like);
    }

    // Remove a like (unlike)
    public void removeLike(Long userId, Long postId) {
        LikeId likeId = new LikeId(userId, postId);
        likeRepository.deleteById(likeId);  // Delete like from repository
    }

    // Check if the user has liked the post
    public boolean isPostLikedByUser(Long userId, Long postId) {
        return likeRepository.existsByIdUserIdAndIdPostId(userId, postId);
    }
}

