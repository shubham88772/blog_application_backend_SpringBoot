package com.blog.project.controller;

import com.blog.project.payloads.UserDto;
import com.blog.project.services.UserService;
import com.blog.project.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public UserDto createUser(@RequestBody UserDto userDto){
        UserDto createdUser=userService.createUser(userDto);
        return createdUser;
    }
    @GetMapping("/allusers")
    public List<UserDto> getAllUsers(){
       List<UserDto> allUsers=this.userService.getAllUser();
       return allUsers;
    }

}
