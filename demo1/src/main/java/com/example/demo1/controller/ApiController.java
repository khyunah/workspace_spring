package com.example.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 주소를 받아서 응답을 처리해주는 

@RestController
@RequestMapping("/api/get")
public class ApiController {

	// URL
	// 자원을 요청하는 주소 체계 방식 .jsp .html

	// URI
	// 식별자 방식
	// ( 스프링에서는 URI방식으로 사용 )

	// http://localhost:9090/api/hello
	// http://localhost:9090/api/get/hello
	@GetMapping("/hello")
	public String getHello() {

		return "sayHello";
	}

	// path-variable 방식
	
	// get 방식 일때 URI방식 사용 ( 데이터를 담아서 요청할 수 있음 ) ㅡ> 처리하고 응답을 해줄수 있다.
	// http://localhost:9090/api/get/path-variable/[xxx]
	// 주소 체계에서는 언더바_ 말고 하이픈- 많이 씀 
	@GetMapping(path = "/path-variable/{name}")	// {name} : 템플릿 변수 
	public String queryParam(@PathVariable(name = "name") String name) {

		System.out.println("브라우저에서 들어온 값을 받음." + name);
		return "[[" + name + "]]";
	}
	
	
	// http://localhost:9090/api/get/path-variable/[xxx]/[xxx]
	@GetMapping(path = "/path-variable/{name}/{age}")
	public String queryParam2(@PathVariable(name = "name") String name,
			@PathVariable(name = "age") int age) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		return "name : " + name + ", age : " + age ;
	}
	
	// 문제 1. 새로운 주소 만들어서 요청 응답 ( 인자값 하나 )
	// 문제 2. 새로운 주소 만들어서 요청 응답 ( 인자값 두개 )
	
	// http://localhost:9090/api/get/book/[xxx]/
	@GetMapping(path = "book/{booktitle}")
	public String queryParam3(@PathVariable(name = "booktitle") String booktitle) {
		return "booktitle : " + booktitle;
	}
	
	// http://localhost:9090/api/get/select/student/[xxx]/[xxx]
	@GetMapping(path = "select/student/{name}/{grade}")
	public String queryParam4(@PathVariable(name = "name") String name,
			@PathVariable(name = "grade") int grade) {
		return "name : " + name + ", grade : " + grade;
	}
}
