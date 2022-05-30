package com.example.demo2.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.dto.UserRequest;

@RestController
@RequestMapping("/api2")
public class PostApiController {

	// Map 방식 
	// @RequestBody
	// http://localhost:9090/api2/post1
	@PostMapping("/post1")
	public String post1(@RequestBody Map<String, Object> requestData) { // @RequestBody :주소에 데이터를 전달하는것이 아닌 바디에 전달한다.
		System.out.println("post1 test1");
		StringBuilder builder = new StringBuilder();
		
		requestData.entrySet().forEach(entry -> {
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			builder.append(entry.getKey() + "=" + entry.getValue());
		});

		return builder.toString();
	}
	
	// DTO 방식
	// @RequestBody
	// http://localhost:9090/api2/post2
	@PostMapping("/post2")
	public String post2(@RequestBody UserRequest requestData) {
		System.out.println(requestData.toString() + " 데이터가 잘 들어옴 ~");
		return requestData.toString();
	}
	
	// 파싱하는것이 하나도 없는데 왜 자동으로 변하는가
	// 메세지 컨버터 라는 녀석이 자동으로 문자열을 파싱해서 UserRequest에 맵핑을 해주고 있음
}
