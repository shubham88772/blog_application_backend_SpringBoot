package com.blog.project.payloads;

import com.blog.project.entities.Post;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private Integer categoryId;
    @NotBlank
    @Size(min = 4,message = "min is 4")
    private String categoryTitle;
    @NotBlank
    @Size(min = 10,message = "min is 10")
    private String categoryDescription;
//    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private List<Post> posts=new ArrayList<>();
}
