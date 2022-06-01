package com.example.validation1.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation1.dto.Student;

// http://localhost:9090/get-valid/test/{number}/{name}/{grade}/{email}
@RestController
@RequestMapping("/get-valid")
@Validated
public class GetValidatedTest {
	
	@GetMapping("/test/{number}/{name}/{grade}/{email}")
	public Student getValidTest(@Max(10) @PathVariable Integer number,
			@Size(max = 10) @PathVariable String name, 
			@PathVariable Integer grade,
			@PathVariable String email) {
		
		Student student = new Student();
		student.setStudentNumber(number);
		student.setName(name);
		student.setGrade(grade);
		student.setEmail(email);
		return student;
	}

}
