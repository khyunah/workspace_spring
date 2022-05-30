package com.example.demo2_1.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2_1.models.UserDto;

@RestController
@RequestMapping("/kimhyunah/220530/post")
public class PostApiController {

	// Map 방식
	// http://localhost:9091/kimhyunah/220530/post/map
	@PostMapping("/map")
	public String post(@RequestBody Map<String, Object> mapData) {
		StringBuilder builder = new StringBuilder();
		
		mapData.entrySet().forEach(entry -> {
			builder.append(entry.getKey() + "=" + entry.getValue());
		});
		return builder.toString();
	}
	
	// DTO 방식
	// http://localhost:9091/kimhyunah/220530/post/dto
	@PostMapping("/dto")
	public String post2(@RequestBody UserDto userDtoData) {
		return userDtoData.toString();
	}
}
