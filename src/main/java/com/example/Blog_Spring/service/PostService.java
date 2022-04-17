package com.example.Blog_Spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Blog_Spring.entities.Post;
import com.example.Blog_Spring.entities.User;
import com.example.Blog_Spring.repos.PostRepository;
import com.example.Blog_Spring.request.PostCreateRequest;
import com.example.Blog_Spring.request.PostUpdateReq;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {
	private PostRepository postRepository;
	private UserService userService;

	public List<Post> getAllPosts(Optional<Long> userId) {
		
		if(userId.isPresent()) {
			return postRepository.findByUserId(userId.get());
			// buraya detayli bak
		} 
		return postRepository.findAll();
	}

	public Post getOnePost(Long postId) {
		return postRepository.getOnePostById(postId);
		
	}

	public Post createPost (PostCreateRequest newPostReq) {
		User tempUser= userService.getOneUserbyId (newPostReq.getUserId());
		
		if(tempUser== null) return null;
		else {
			Post toSave= new Post();
			toSave.setId(newPostReq.getId());
			toSave.setText(newPostReq.getText());
			toSave.setTitle(newPostReq.getTitle());
			toSave.setUser(tempUser);
			return postRepository.save(toSave);
		}
	
		
	}



	public void deleteOnePost(Long postId) {
	 postRepository.deleteById(postId);
		
	}

	public Post updateOnePost(Long postId, PostUpdateReq postUpdateReq) {
		Optional <Post> tempPost= postRepository.findById(postId);
		if (tempPost.isPresent()) {
			
			Post post= tempPost.get();
			post.setText(postUpdateReq.getText());
			post.setTitle(postUpdateReq.getTitle());
			return postRepository.save(post);
		}
		return null;
 	
	}
}
