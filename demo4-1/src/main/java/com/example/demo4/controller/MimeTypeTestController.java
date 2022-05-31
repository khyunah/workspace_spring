package com.example.demo4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.dto.RequestUserDto;

// 리턴타입에 따른 MIME TYPE 확인하기

@RestController
@RequestMapping("/mime")
public class MimeTypeTestController {

	@GetMapping("/text")
	public String textPlane(@RequestParam String name) {
		return name;
	}
	
	@PostMapping("/post-json")
	public RequestUserDto json(@RequestBody RequestUserDto dto) {
		return dto;
	}
	
	@PostMapping("post-entity")
	public ResponseEntity<RequestUserDto> entity(@RequestBody RequestUserDto dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
}
