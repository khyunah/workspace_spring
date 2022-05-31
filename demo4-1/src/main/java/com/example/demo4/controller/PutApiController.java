package com.example.demo4.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.dto.RequestUserDto;

@RestController
@RequestMapping("/kimhyunah")
public class PutApiController {
	
	// Object 타입을 보내는 것 
	@PutMapping("/put")
	public RequestUserDto put1(@RequestBody RequestUserDto dto) {
		return dto;
	}
	
	// Object타입, path-variable 로 같이 보내는 것
	@PutMapping("/path-put/{id}")
	public RequestUserDto put2(@RequestBody RequestUserDto dto, @PathVariable(name = "id") String id) {
		return dto;
	}

}
