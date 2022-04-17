package com.example.Blog_Spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Blog_Spring.entities.User;
import com.example.Blog_Spring.repos.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		
		
		return userRepository.findAll();
	}

	public User getOneUserbyId(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User createUser(User newUser) {
		// TODO Auto-generated method stub
		return userRepository.save(newUser);
	}

	public User updateOneUser(Long userId, User newUser) {
		Optional<User> user= userRepository.findById(userId);
			
		if (user.isPresent()) {
			User tempUser= user.get();
			tempUser.setUserName(newUser.getUserName());
			tempUser.setPassword(newUser.getPassword());
			return userRepository.save(tempUser);
					
		} else return null;
	}

	public void deleteOneUser(Long userId) {
		userRepository.deleteById(userId);
	}

	
	
	

}
