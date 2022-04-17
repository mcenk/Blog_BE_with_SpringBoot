package com.example.Blog_Spring.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Blog_Spring.entities.User;
import com.example.Blog_Spring.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
	
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public User getOneUser (@PathVariable Long userId) {
		return userService.getOneUserbyId(userId);
		// Optinal gelmesine karsilik simdi orElse dedik sonra duzeltiriz
		
	}

	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userService.createUser(newUser);
		
	}
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId ,@RequestBody User newUser ) {
		return userService.updateOneUser(userId,newUser);
	}
			
			
	
	@DeleteMapping("/{userId}")
	
	public void deleteOneUser(@PathVariable Long userId) {
		
		 userService.deleteOneUser(userId);
	}
		
	
	
	
}
