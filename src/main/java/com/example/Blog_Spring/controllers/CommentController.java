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

import com.example.Blog_Spring.entities.Comment;

import com.example.Blog_Spring.request.CommentCreateReq;
import com.example.Blog_Spring.request.CommentUpdateReq;

import com.example.Blog_Spring.service.CommentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/comments")

public class CommentController {

	
	private CommentService commentService;
	
	@GetMapping
	public List<Comment> getAllComments(@RequestParam Optional<Long> userId,
			@RequestParam Optional<Long> postId){
		
		return commentService.getAllComments(userId,postId);
	}
	@GetMapping("/{commentId}")
	public Comment getOneCommentById(@PathVariable Long commentId) {
		
		return commentService.getOneCommentById(commentId);
	}
	
	@PostMapping 
	public Comment createOneComment(@RequestBody CommentCreateReq commentCreateReq) {
		
		return commentService.createOneComment(commentCreateReq);
	}
	
	@PutMapping("/{commentId}")
	public Comment updateOneComment ( @PathVariable Long commentId,@RequestBody CommentUpdateReq commentUpdateReq ) {
		
		return commentService.updateOneComment(commentId,commentUpdateReq);
	
	}
	
	@DeleteMapping("/{commentId}")
	public void deleteOneComment(@PathVariable Long commentId) {
		
		commentService.deleteOneComment(commentId);
		
	}
	
}
