package com.example.validation1.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation1.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {

	@PostMapping("/user")
	public ResponseEntity<User> user(@Valid @RequestBody User user) {

		// 예전방식
		if (user.getAge() < 1 || user.getAge() > 110) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}
		
		// 에러가 발생하면 custom해서 프론트 개발자가 잘 처리할 수 있도록 설계해야 한다. 
		System.out.println(user);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
