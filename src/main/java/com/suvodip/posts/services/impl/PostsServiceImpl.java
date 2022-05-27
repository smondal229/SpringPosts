package com.suvodip.posts.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.suvodip.posts.exceptions.ResourceNotFoundException;
import com.suvodip.posts.models.Post;
import com.suvodip.posts.repositories.PostsRepository;
import com.suvodip.posts.services.PostsService;

@Service
public class PostsServiceImpl implements PostsService {
	private PostsRepository postsRepository;
	
	public PostsServiceImpl(PostsRepository postsRepository) {
		super();
		this.postsRepository = postsRepository;
	}

	@Override
	public List<Post> getAllPosts() {
		return postsRepository.findAll();
	}

	@Override
	public Post getPost(Long id) {
		return postsRepository.findById(id).get();
	}

	@Override
	public Post createPost(Post post) {
		return postsRepository.save(post);
	}

	@Override
	public Post updatePost(Post post, Long id) {
		Post existingPost = postsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", String.valueOf(id)));
		existingPost.setDescription(post.getDescription());
		return postsRepository.save(existingPost);
	}

	@Override
	public void deletePost(Long id) {
		Post existingPost = postsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", String.valueOf(id)));
		postsRepository.delete(existingPost);
	}

}
