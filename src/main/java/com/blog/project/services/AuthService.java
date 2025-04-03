package com.blog.project.services;

import com.blog.project.payloads.SignUpDto;
import com.blog.project.payloads.SignUpResponseDto;

public interface AuthService {
    SignUpResponseDto signUp(SignUpDto signUpDto);
}
