package com.blog.project.repositories;

import com.blog.project.entities.Comment;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
