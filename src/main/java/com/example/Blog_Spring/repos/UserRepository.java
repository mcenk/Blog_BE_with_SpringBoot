package com.example.Blog_Spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Blog_Spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
