package com.example.Blog_Spring.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Blog_Spring.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByUserId(Long userId);

	Post getOnePostById(Long postId);

}
