package com.example.Blog_Spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Blog_Spring.entities.Comment;
import com.example.Blog_Spring.entities.Post;
import com.example.Blog_Spring.entities.User;
import com.example.Blog_Spring.repos.CommentRepository;
import com.example.Blog_Spring.request.CommentCreateReq;
import com.example.Blog_Spring.request.CommentUpdateReq;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentService {
	
	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;
	
	


	public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId) {
		
		if ( userId.isPresent() && postId.isPresent()) {
			return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}
		else if(userId.isPresent()) {
			return commentRepository.findByUserId(userId.get());
		}
		else if(postId.isPresent()) {
			return commentRepository.findByPostId(postId.get());
		} else
			return commentRepository.findAll();
	}


	public Comment getOneCommentById(Long commentId) {
		return commentRepository.getOneCommentById(commentId);
	}


	public Comment createOneComment(CommentCreateReq commentCreateReq) {
		
		User tempUser= userService.getOneUserbyId(commentCreateReq.getUserId());
		Post tempPost= postService.getOnePost(commentCreateReq.getPostId());
		
		 if ( tempUser!= null && tempPost != null) {
		
			 Comment comment= new Comment();
			 comment.setId(commentCreateReq.getId());
			 comment.setUser(tempUser);
			 comment.setPost(tempPost);
			 comment.setText(commentCreateReq.getText());
			 return commentRepository.save(comment);
			 
		 } else return null;

	}


	public Comment updateOneComment(Long commentId, CommentUpdateReq commentUpdateReq) {
		Optional <Comment> tempComment= commentRepository.findById(commentId);
		if (tempComment.isPresent()) {
			
			Comment comment= tempComment.get();
			comment.setText(commentUpdateReq.getText());
			return commentRepository.save(comment);
		}
		return null;
	}


	public void deleteOneComment(Long commentId) {
		commentRepository.deleteById(commentId);
		
	}



	
	
	

}
