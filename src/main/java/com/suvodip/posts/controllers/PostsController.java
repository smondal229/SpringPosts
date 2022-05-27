package com.suvodip.posts.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suvodip.posts.models.Post;
import com.suvodip.posts.services.PostsService;


@RestController
@RequestMapping("/api/posts")
public class PostsController {
	private PostsService postsService;

	public PostsController(PostsService postsService) {
		super();
		this.postsService = postsService;
	}
	
	@GetMapping()
	public ResponseEntity<List<Post>> getAllPosts() {
		return new ResponseEntity<List<Post>>(postsService.getAllPosts(), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Post> addPost(@RequestBody Post post) {
		return new ResponseEntity<Post>(postsService.createPost(post), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Post> updatePost(@RequestBody Post post, @PathVariable("id") Long id) {
		return new ResponseEntity<Post>(postsService.updatePost(post, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Post> removePost(@PathVariable("id") Long id) {
		postsService.deletePost(id);
		return new ResponseEntity<Post>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> getPost(@PathVariable("id") Long id) {
		return new ResponseEntity<Post>(postsService.getPost(id), HttpStatus.OK);
	}
}
