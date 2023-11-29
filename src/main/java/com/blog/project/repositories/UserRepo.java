package com.blog.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.project.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
