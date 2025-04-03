package com.blog.project;

import com.blog.project.entities.User;
import com.blog.project.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogAppApisApplicationTests {
	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {
		User user = new User("Shubham",4,"shubham@gmail.com", "1234");

		String token = jwtService.generateAccessToken(user);

		System.out.println(token);

		Long id = jwtService.getUserIdFromToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0IiwiZW1haWwiOiJzaHViaGFtQGdtYWlsLmNvbSIsInJvbGUiOlsiQURNSU4iLCJVU0VSIl0sImlhdCI6MTc0MzY1NTE1NSwiZXhwIjoxNzQzNjU1MjE1fQ.7XpAfIoF2RvPEiw9koOPOiQXGYOkRa0XYrVMcv8y-ZI");

		System.out.println(id);

	}

	}
