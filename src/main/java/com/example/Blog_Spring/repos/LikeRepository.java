package com.example.Blog_Spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Blog_Spring.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

}
