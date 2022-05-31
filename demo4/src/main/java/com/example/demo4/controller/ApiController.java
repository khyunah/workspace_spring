package com.example.demo4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.dto.User;

// MIME YTPE 
@RestController
@RequestMapping("/api")
public class ApiController {

	// text/plain
	// 리턴타입이 String 이면 자동으로 text/plain 타입이 된다.
	@GetMapping("/text")
	public String text(@RequestParam String account) {
		return account;
	}

	// application/json
	// 리턴타입이 Object 이면 자동으로 text/plain 타입이 된다.
	// 요청이 있으면 컨버터가 object를 맵핑해준다. object가 메소드로 나옴
	@PostMapping("/json")
	public User json(@RequestBody User user) {
		System.out.println(user.getName());
		return user;
	}

	@PutMapping("/put")
	public ResponseEntity<User> put(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
}
