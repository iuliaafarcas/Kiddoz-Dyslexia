package com.kiddoz.dyslexia.controller;

import com.kiddoz.dyslexia.model.Comment;
import com.kiddoz.dyslexia.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Add a comment to a post
    @PostMapping("/posts/{postId}")
    public ResponseEntity<Comment> addComment(@PathVariable Long postId, @RequestBody Comment comment) {
        Comment savedComment = commentService.addComment(postId, comment);
        return ResponseEntity.ok(savedComment);
    }

    // Get all comments for a post
    @GetMapping("/posts/{postId}")
    public ResponseEntity<List<Comment>> getCommentsForPost(@PathVariable Long postId) {
        List<Comment> comments = commentService.getCommentsForPost(postId);
        return ResponseEntity.ok(comments);
    }
}
