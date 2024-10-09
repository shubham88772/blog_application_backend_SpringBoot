package com.blog.project.payloads;

import com.blog.project.entities.Category;
import com.blog.project.entities.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private int id;

    @NotNull(message = "Title should not be empty")
    @Size(min = 10,max = 2000,message = "Min length should be 10 and max should be 2000")
    private String title;
    @NotNull(message = "Content should not be empty")
    @Size(min = 10,max = 2000,message = "Min length should be 10 and max should be 2000")
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;


}
