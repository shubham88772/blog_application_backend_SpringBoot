package com.blog.project.controller;

import com.blog.project.payloads.ApiResponse;
import com.blog.project.payloads.CommentDto;
import com.blog.project.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commentapi")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/create/comment/user/{userId}/post/{postId}")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@PathVariable Integer userId,@PathVariable Integer postId){
        CommentDto comment = this.commentService.createComment(commentDto, userId,postId);
        return new ResponseEntity<CommentDto>(comment, HttpStatus.OK);

    }
    @DeleteMapping("/delete/commentId/{commentId}")
    public ApiResponse deleteComment(@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);
        return new ApiResponse("Comment Deleted Successfully",true);
    }
}
