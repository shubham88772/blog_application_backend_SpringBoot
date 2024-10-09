package com.blog.project.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Parent;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private int id;
	@NotEmpty
	@Size(min=4,message = "User name must be of 4 or more characters")
	private String name;
	@Email(message = "Email address is not valid!!")
	private String email;
	@NotEmpty
	@Size(min = 6,max = 15,message = "Password Must Be Minimum of 6 char and max of 10 char")
	private String password;
	@NotEmpty
	private String about;

}
