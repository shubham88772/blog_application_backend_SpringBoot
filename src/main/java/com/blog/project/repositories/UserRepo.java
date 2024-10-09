package com.blog.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.project.entities.User;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer>{

    Optional<User> findByEmail(String email);

}
