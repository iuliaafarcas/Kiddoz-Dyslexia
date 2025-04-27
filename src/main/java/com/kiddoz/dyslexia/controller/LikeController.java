package com.kiddoz.dyslexia.controller;


import com.kiddoz.dyslexia.service.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/{userId}/posts/{postId}")
    public ResponseEntity<String> addLike(@PathVariable Long userId, @PathVariable Long postId) {
        try {
            likeService.addLike(userId, postId);
            return ResponseEntity.ok("Post liked successfully");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(400).body("User has already liked this post");
        }
    }

    @DeleteMapping("/{userId}/posts/{postId}")
    public ResponseEntity<String> removeLike(@PathVariable Long userId, @PathVariable Long postId) {
        likeService.removeLike(userId, postId);
        return ResponseEntity.ok("Like removed successfully");
    }

    @GetMapping("/{userId}/posts/{postId}/liked")
    public ResponseEntity<Boolean> isPostLiked(@PathVariable Long userId, @PathVariable Long postId) {
        boolean liked = likeService.isPostLikedByUser(userId, postId);
        return ResponseEntity.ok(liked);
    }
}
