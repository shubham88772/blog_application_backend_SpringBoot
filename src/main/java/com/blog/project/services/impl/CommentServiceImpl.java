package com.blog.project.services.impl;

import com.blog.project.entities.Comment;
import com.blog.project.entities.Post;
import com.blog.project.entities.User;
import com.blog.project.exceptions.ResourceNotFoundException;
import com.blog.project.payloads.CommentDto;
import com.blog.project.repositories.CommentRepo;
import com.blog.project.repositories.PostRepo;
import com.blog.project.repositories.UserRepo;
import com.blog.project.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto,Integer userId, Integer postId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));
        Comment map = this.modelMapper.map(commentDto, Comment.class);
        map.setUser(user);
        map.setPost(post);
        Comment save = commentRepo.save(map);
        CommentDto map1 = modelMapper.map(save, CommentDto.class);
        return map1;
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "commentId", commentId));
        this.commentRepo.delete(comment);
    }


}
