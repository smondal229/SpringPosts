package com.suvodip.posts.models;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="posts")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="description", nullable=false)
	@NonNull
	private String description;
	
	@CreationTimestamp
	@Column(name="created_at", nullable=false, updatable=false)
	private Timestamp createdAt;

	@UpdateTimestamp
	@Column(name="updated_at", nullable=false)
	private Timestamp updatedAt;
}
