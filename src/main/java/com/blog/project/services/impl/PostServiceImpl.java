package com.blog.project.services.impl;

import com.blog.project.entities.Category;
import com.blog.project.entities.Post;
import com.blog.project.entities.User;
import com.blog.project.exceptions.ResourceNotFoundException;
import com.blog.project.payloads.PostDto;
import com.blog.project.repositories.CategoryRepo;
import com.blog.project.repositories.PostRepo;
import com.blog.project.repositories.UserRepo;
import com.blog.project.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","userId",userId));
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));

        Post map = this.modelMapper.map(postDto, Post.class);
        map.setImageName("default.png");
        map.setAddedDate(new Date());
        map.setUser(user);
        map.setCategory(category);
        Post save = postRepo.save(map);
        PostDto map1 = modelMapper.map(save, PostDto.class);
        return map1;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
        Post updatedPost = postRepo.save(post);
        return this.modelMapper.map(updatedPost,PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));
        postRepo.delete(post);
    }

    @Override
    public List<PostDto> getAllPost(Integer pageNumber,Integer pageSize) {
        Pageable p= PageRequest.of(pageNumber,pageSize);
        Page<Post> pagePost = this.postRepo.findAll(p);
        List<Post> allPost = pagePost.getContent();
        List<PostDto> collect = allPost.stream().map((posts) -> this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));
        PostDto map = modelMapper.map(post, PostDto.class);
        return map;
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        List<Post> byCategory = this.postRepo.findByCategory(category);
        List<PostDto> allPost=byCategory.stream().map((post) -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return allPost;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","userId",userId));
        List<Post> byUser = this.postRepo.findByUser(user);
        List<PostDto> collect = byUser.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<Post> searchPost(String keyword) {
        return null;
    }
}
