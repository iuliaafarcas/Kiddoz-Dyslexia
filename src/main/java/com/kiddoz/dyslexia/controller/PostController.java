package com.kiddoz.dyslexia.controller;

import com.kiddoz.dyslexia.model.PostEntity;
import com.kiddoz.dyslexia.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Create a new post
    @PostMapping
    public ResponseEntity<PostEntity> createPost(@RequestBody PostEntity post) {
        PostEntity createdPost = postService.createPost(post);
        return ResponseEntity.ok(createdPost);
    }

    // Get a post by ID
    @GetMapping("/{id}")
    public ResponseEntity<PostEntity> getPostById(@PathVariable Long id) {
        Optional<PostEntity> post = postService.getPostById(id);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all posts by a specific author (user)
    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<PostEntity>> getPostsByAuthor(@PathVariable Long authorId) {
        List<PostEntity> posts = postService.getPostsByAuthor(authorId);
        return ResponseEntity.ok(posts);
    }

    // Search posts by title
    @GetMapping("/search")
    public ResponseEntity<List<PostEntity>> searchPostsByTitle(@RequestParam String title) {
        List<PostEntity> posts = postService.searchPostsByTitle(title);
        return ResponseEntity.ok(posts);
    }

    // Delete a post by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok("Post deleted successfully");
    }
}
