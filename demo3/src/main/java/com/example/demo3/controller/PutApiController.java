package com.example.demo3.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.dto.PutRequestDto;

@RestController
@RequestMapping("/api")
public class PutApiController {

	// 오브젝트로만 데이터 받기
	// 리턴 타입 String이랑 오브젝트 타입 차이 확인하기
//	@PutMapping("/put")
//	public PutRequestDto put(@RequestBody PutRequestDto requestDto) {
//		System.out.println(requestDto.toString());
//		return requestDto;
//	}

	// path-variable과 오브젝트 방식 같이 사용하기
	@PutMapping("/put/{userId}")
	public PutRequestDto put(@RequestBody PutRequestDto requestDto, @PathVariable(name = "userId") Long userId) {
		System.out.println("userId : " + userId);
		System.out.println(requestDto.toString());
		return requestDto;
	}

}
