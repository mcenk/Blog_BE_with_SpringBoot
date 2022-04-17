package com.example.Blog_Spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Blog_Spring.entities.Post;
import com.example.Blog_Spring.request.PostCreateRequest;
import com.example.Blog_Spring.request.PostUpdateReq;
import com.example.Blog_Spring.service.PostService;


import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/posts")

public class PostController {

	private PostService postService;


@GetMapping	
public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
	
	return postService.getAllPosts(userId);
}

@GetMapping("/{postId}")
public Post getOnePost (@PathVariable Long postId) {
	return postService.getOnePost(postId);
}
@PostMapping
public Post createPost(@RequestBody PostCreateRequest newPostReq){
	
	return postService.createPost(newPostReq);
}

@PutMapping("/{postId}")
public Post updateOnePost ( @PathVariable Long postId,@RequestBody PostUpdateReq postUpdateReq ) {
	
	return postService.updateOnePost(postId,postUpdateReq);
}

@DeleteMapping("/{postId}")
public void deleteOnePost(@PathVariable Long postId) {
	
	postService.deleteOnePost(postId);
}



}
