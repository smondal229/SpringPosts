package com.suvodip.posts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suvodip.posts.models.Post;

public interface PostsRepository extends JpaRepository<Post, Long> {
	
}
