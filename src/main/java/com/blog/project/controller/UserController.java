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
    @PutMapping("/update/{userId}")
    public UserDto updatedUser(@RequestBody UserDto userDto,@PathVariable int userId){
        UserDto updated=userService.updateUser(userDto,userId);
        return updated;

    }
    @GetMapping("/userid/{userId}")
    public UserDto findById(@PathVariable int userId){
        UserDto user=userService.getUserById(userId);
        return user;

    }
    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable int userId){
        this.userService.deleteUser(userId);
    }

}
