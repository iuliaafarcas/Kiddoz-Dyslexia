package com.kiddoz.dyslexia.repository;

import com.kiddoz.dyslexia.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    // Find all posts by a specific user (author)
    List<PostEntity> findByAuthorId(Long authorId);

    // Find a post by its title
    List<PostEntity> findByTitleContaining(String title);

    // Optionally, you can add custom queries for more advanced use cases
}
