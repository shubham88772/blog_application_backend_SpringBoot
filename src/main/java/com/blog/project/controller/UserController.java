package com.blog.project.controller;

import com.blog.project.payloads.ApiResponse;
import com.blog.project.payloads.UserDto;
import com.blog.project.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUser=userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @GetMapping("/allusers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
       List<UserDto> allUsers=this.userService.getAllUser();
       return new ResponseEntity<>(allUsers,HttpStatus.ACCEPTED);
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updatedUser(@Valid @RequestBody UserDto userDto,@PathVariable int userId){
        UserDto updated=userService.updateUser(userDto,userId);
        return ResponseEntity.ok(updated);

    }
    @GetMapping("/userid/{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable int userId){
        UserDto user=userService.getUserById(userId);
        return ResponseEntity.ok(user);

    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User deleted successfull",true),HttpStatus.OK);
    }
//    @GetMapping("/login/{userId}")
//    public boolean login(@RequestBody UserDto userDto, @PathVariable int userId ){
//        boolean loggedin=false;
//        String id=userDto.getEmail();
//        String pass=userDto.getPassword();
//        if (userService.getUserById(userId).getEmail()==id&&userService.getUserById(userId).getPassword()==pass){
//            loggedin=true;
//        }else {
//            loggedin=false;
//        }
//        return loggedin;
//    }
    @GetMapping("/login")
    public boolean login(@RequestBody UserDto userDto){
        boolean valid=userService.login(userDto);
        return valid;
    }

}
