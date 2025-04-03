package com.blog.project.payloads;

import lombok.Data;

@Data
public class SignUpDto {
    private String email;
    private String password;
    private String name;

}
