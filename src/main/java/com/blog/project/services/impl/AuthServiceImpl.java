package com.blog.project.services.impl;

import com.blog.project.entities.User;
import com.blog.project.exceptions.ResourceNotFoundException;
import com.blog.project.payloads.SignUpDto;
import com.blog.project.payloads.SignUpResponseDto;
import com.blog.project.repositories.UserRepo;
import com.blog.project.services.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public SignUpResponseDto signUp(SignUpDto signUpDto) {
       Optional<User> user = userRepo.findByEmail(signUpDto.getEmail());
        if (user.isPresent()){
            throw new BadCredentialsException("user with email already exist"+signUpDto.getEmail());
        }
        User toBeCreated=modelMapper.map(signUpDto,User.class);
        toBeCreated.setPassword(passwordEncoder.encode(toBeCreated.getPassword()));
        User save = userRepo.save(toBeCreated);
        return modelMapper.map(save,SignUpResponseDto.class);
    }
}
