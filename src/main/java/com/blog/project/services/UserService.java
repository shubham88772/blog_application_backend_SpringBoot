package com.blog.project.services;

import java.util.List;

import com.blog.project.payloads.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user,int userId);
	
	UserDto getUserById(int userId);
	
	List<UserDto> getAllUser();
	
	void deleteUser(int userId);
	

}
