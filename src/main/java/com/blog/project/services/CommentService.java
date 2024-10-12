package com.blog.project.services;

import com.blog.project.payloads.CommentDto;

public interface CommentService {
    //Create Comment

    public CommentDto createComment(CommentDto commentDto,Integer userId,Integer postId);

    //Get comment by post

    public void deleteComment(Integer commentId);

}
