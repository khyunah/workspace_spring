package com.example.validation1.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation1.dto.Student;

@RestController
@RequestMapping("vali-test")
public class ValidationTestController {
	
	@PostMapping("student")
	public Student createStudent(@Valid @RequestBody Student student) {
		return student;
	}

}
