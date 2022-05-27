package com.suvodip.posts.services;

import java.util.List;

import com.suvodip.posts.models.Post;

public interface PostsService {
	public List<Post> getAllPosts();
	
	public Post getPost(Long id);
	
	public Post createPost(Post post);
	
	public Post updatePost(Post post, Long id);
	
	public void deletePost(Long id);
}
