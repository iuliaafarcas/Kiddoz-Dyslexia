package com.kiddoz.dyslexia.repository;


import com.kiddoz.dyslexia.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // You can add custom queries here if needed

    // Find all comments for a specific post
    List<Comment> findByPostId(Long postId);

    // Find all comments by a specific user
    List<Comment> findByAuthorId(Long authorId);
}