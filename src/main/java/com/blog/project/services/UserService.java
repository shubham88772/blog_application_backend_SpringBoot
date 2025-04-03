package com.blog.project.services;

import java.util.List;

import com.blog.project.payloads.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  {
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto userDto,int userId);

	UserDto getUserById(int userId);
	
	List<UserDto> getAllUser();
	
	void deleteUser(int userId);


	boolean login(UserDto userDto);
}
//extends UserDetailsService