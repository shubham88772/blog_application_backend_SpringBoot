package com.blog.project.services;

import com.blog.project.entities.Post;
import com.blog.project.payloads.PostDto;
import com.blog.project.payloads.PostResponse;

import java.util.List;

public interface PostService {
    //create

    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    //update

    PostDto updatePost(PostDto postDto,Integer postId);

    //delete

    void deletePost(Integer postId);

    //get all posts

    PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);

    //get single post

    PostDto getPostById(Integer postId);

    //get all post by category

    List<PostDto> getPostByCategory(Integer categoryId);

    //get all post by user

    List<PostDto> getPostByUser(Integer userId);

    //search post

    List<PostDto> searchPost(String keyword);


}
