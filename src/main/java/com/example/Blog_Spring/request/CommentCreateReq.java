package com.example.Blog_Spring.request;

import lombok.Data;

@Data
public class CommentCreateReq {

	Long id;
	Long userId, postId;
    String text ;
    
}
