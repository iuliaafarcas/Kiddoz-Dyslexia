package com.kiddoz.dyslexia.service;

import com.kiddoz.dyslexia.model.PostEntity;
import com.kiddoz.dyslexia.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Create a new post
    public PostEntity createPost(PostEntity post) {
        return postRepository.save(post);
    }

    // Get a post by ID
    public Optional<PostEntity> getPostById(Long id) {
        return postRepository.findById(id);
    }

    // Get all posts by a specific author (user)
    public List<PostEntity> getPostsByAuthor(Long authorId) {
        return postRepository.findByAuthorId(authorId);
    }

    // Search posts by title keyword
    public List<PostEntity> searchPostsByTitle(String title) {
        return postRepository.findByTitleContaining(title);
    }

    // Delete a post by ID
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
