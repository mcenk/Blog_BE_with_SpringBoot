package com.example.Blog_Spring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity // bu alan db a post edilecek
@Table (name= "user") // db uzerindeki adi bu olacak
@Data
public class User {
	@Id
	Long id;
	String userName;
	String password;

}
