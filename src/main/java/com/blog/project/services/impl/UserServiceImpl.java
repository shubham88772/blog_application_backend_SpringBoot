package com.blog.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.project.entities.User;
import com.blog.project.payloads.UserDto;
import com.blog.project.repositories.UserRepo;
import com.blog.project.services.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto user) {
		// TODO Auto-generated method stub
		User user1=this.dtoToUser(user);
		
		this.userRepo.save(user1);
		return null;
	}

	@Override
	public UserDto updateUser(UserDto user, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub

	}
	private User dtoToUser(UserDto userDto) {

		User user = new User();

		user.setId(userDto.getId());

		user.setName(userDto.getName());

		user.setEmail(userDto.getEmail());

		user.setAbout(userDto.getAbout());

		user.setPassword(userDto.getPassword());

		return user;

		}

		public UserDto userToDto(User user) {

		UserDto userDto = new UserDto();

		userDto.setId(user.getId());

		userDto.setName(user.getName());

		userDto.setEmail(user.getEmail()); 
		
		userDto.setPassword(user.getPassword());

		userDto.setAbout(user.getAbout());

		return userDto;

}
