package com.example.validation1.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation1.dto.Student;

@RestController
@RequestMapping("/binding")
public class BindingResultTestController {

	@PostMapping("/student")
	public ResponseEntity<?> user(@Valid @RequestBody Student student, BindingResult bindingResult) {

		// 1. 
		// 에러가 있다면
		if (bindingResult.hasErrors()) {

			StringBuffer sb = new StringBuffer();

			// 2.
			// 에러를 전부 담아서 for문을 돌려서
			bindingResult.getAllErrors().forEach(error -> {

				// 3.
				// FieldError 타입으로 error에 대한 정보를 담아 뒀다.
				FieldError fError = (FieldError) error;

				// 4.
				// 에러의 필드와 메세지를 StringBuffer에 담는다.
				sb.append("feild : " + fError.getField() + "\n");
				sb.append("massage : " + fError.getDefaultMessage() + "\n");

			});

			// 5. 
			// 실패를 뜻하는 400번 코드 BAD_REQUEST를 셋팅해서 
			// 오류 필드와 메세지를 append한 StringBuffer를 바디에 담아 보낸다.
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}
		
		// 1.
		// 에러가 없다면 성공 코드를 셋팅해서 
		// 사용자가 입력한 Student 객체를 바디에 담아 보낸다.
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
	}
}
