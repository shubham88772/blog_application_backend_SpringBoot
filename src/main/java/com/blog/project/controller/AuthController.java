package com.blog.project.controller;

import com.blog.project.payloads.SignUpDto;
import com.blog.project.payloads.SignUpResponseDto;
import com.blog.project.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpDto signUpDto){
       SignUpResponseDto signUpResponseDto= authService.signUp(signUpDto);
       return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);

    }
    @GetMapping("/data")
    public String getData(){
        return "Test Success";
    }


}
