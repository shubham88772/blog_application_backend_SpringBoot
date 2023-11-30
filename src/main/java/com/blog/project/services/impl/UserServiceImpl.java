package com.blog.project.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import com.blog.project.exceptions.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.project.entities.User;
import com.blog.project.payloads.UserDto;
import com.blog.project.repositories.UserRepo;
import com.blog.project.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user= this.dtoToUser(userDto);
		User savedUser=this.userRepo.save(user);
		UserDto afterConversion=this.userToDto(savedUser);
		return afterConversion;
	}

	@Override
	public UserDto updateUser(UserDto userDto, int userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		// TODO Auto-generated method stub
		user.setName(userDto.getName());
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		User updated=userRepo.save(user);
		UserDto updatedToDto=this.userToDto(updated);

		return updatedToDto;
	}

	@Override
	public UserDto getUserById(int userId) {
		// TODO Auto-generated method stub
		User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		UserDto userDto=userToDto(user);
		return userDto;
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> allUser=userRepo.findAll();
		List<UserDto> dtoUsers=allUser.stream().map(user -> userToDto(user)).collect(Collectors.toList());
		return dtoUsers;
	}

	@Override
	public void deleteUser(int userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new  ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);
		// TODO Auto-generated method stub

	}

	private User dtoToUser(UserDto userDto) {
		User user=this.modelMapper.map(userDto,User.class);

//		user.setId(userDto.getId());
//
//		user.setName(userDto.getName());
//
//		user.setEmail(userDto.getEmail());
//
//		user.setAbout(userDto.getAbout());
//
//		user.setPassword(userDto.getPassword());

		return user;

	}

	public UserDto userToDto(User user) {
		UserDto userDto=this.modelMapper.map(user,UserDto.class);

//		userDto.setId(user.getId());
//
//		userDto.setName(user.getName());
//
//		userDto.setEmail(user.getEmail());
//
//		userDto.setPassword(user.getPassword());
//
//		userDto.setAbout(user.getAbout());

		return userDto;

	}
}
