package com.blog.project.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
