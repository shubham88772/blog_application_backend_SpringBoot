package com.blog.project.payloads;

import lombok.Data;

@Data
public class SignUpResponseDto {
    private Long id;
    private String email;
    private String name;

}
