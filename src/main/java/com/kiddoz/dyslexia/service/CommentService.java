package com.kiddoz.dyslexia.service;


import com.kiddoz.dyslexia.model.Comment;
import com.kiddoz.dyslexia.model.PostEntity;
import com.kiddoz.dyslexia.repository.CommentRepository;
import com.kiddoz.dyslexia.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    // Add a comment to a post
    public Comment addComment(Long postId, Comment comment) {
        PostEntity post = postRepository.findById(postId).orElseThrow();
        comment.setPost(post);  // Link the comment to the post
        return commentRepository.save(comment); // Save the comment
    }

    // Get all comments for a specific post
    public List<Comment> getCommentsForPost(Long postId) {
        return commentRepository.findByPostId(postId);
    }
}
