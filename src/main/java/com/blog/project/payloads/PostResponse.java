package com.blog.project.payloads;

import com.blog.project.entities.Post;
import lombok.Data;

import java.util.List;
@Data
public class PostResponse {
    List<PostDto> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean lastPage;


}
