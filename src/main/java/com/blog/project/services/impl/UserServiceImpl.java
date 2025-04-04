package com.blog.project.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.blog.project.exceptions.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.project.entities.User;
import com.blog.project.payloads.UserDto;
import com.blog.project.repositories.UserRepo;
import com.blog.project.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user= this.dtoToUser(userDto);
////		String mail= String.valueOf(userRepo.findByEmail(user.getEmail()));
////		if(user.getEmail().equals(mail)){
////			System.out.println("User Already Exist");
////		}
//		Optional<User> existingUser=userRepo.findByEmail(user.getEmail());
//		if (existingUser.isPresent()){
//			return "User Already Exist"+" "+user.getEmail();
//		}else {
//			User savedUser=this.userRepo.save(user);
//			UserDto afterConversion=this.userToDto(savedUser);
//			return "User Saved";
//		}
		User saved = userRepo.save(user);
		UserDto converted=userToDto(saved);
		return converted;

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

	@Override
	public boolean login(UserDto userDto) {
		boolean trueOrFalse;
		User toUser=this.modelMapper.map(userDto,User.class);
		User found=this.userRepo.findById(userDto.getId()).orElseThrow(()-> new ResourceNotFoundException("User","Id", userDto.getId()));
//		System.out.println(toUser.getEmail());
//		System.out.println(toUser.getPassword());
//		System.out.println(found.getEmail());
//		System.out.println(found.getPassword());
		if(toUser.getEmail().equals(found.getEmail())&& toUser.getPassword().equals(found.getPassword())){
			trueOrFalse=true;
			System.out.println("User Loggedin");
		}else{
			trueOrFalse=false;
			System.out.println("Not Authenticated");
		}
		return trueOrFalse;

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

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User not found","try again"));
//	}
}
