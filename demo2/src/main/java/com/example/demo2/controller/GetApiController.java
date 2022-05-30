package com.example.demo2.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.dto.UserRequest;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

	// 주소 : http://localhost:9090/api/get/hello
	@GetMapping("/hello")
	public String getHello() {
		return "sayHello";
	}

	/*
	 * path-Variable 방식
	 */

	// 주소 : http://localhost:9090/api/get/path-variable/{name}/{age}
	@GetMapping(path = "/path-variable/{name}/{age}")
	public String qeuryParam(@PathVariable(name = "name") String name, @PathVariable(name = "age") int age) {

		System.out.println("name : " + name);
		System.out.println("age : " + age);

		String myName = " [[ " + name + " ]] ";
		String myAge = " [[ " + age + " ]] ";

		return "name : " + myName + ", age : " + myAge;
	}

	/*
	 * Query Parameter 방식 ( 3가지 )
	 */
	
	// 1. 키값을 지정해서 값을 받는 방식
	
	// 주소 : http://localhost:9090/api/get/query-param1?name=홍길동&email=ten@naver.com&age=11
	@GetMapping("/query-param1")
	public String queryParam(@RequestParam String name, @RequestParam String email, @RequestParam int age) {
		return "name : " + name + ", email : " + email + ", age : " + age;
	}

	// 2. Map 활용 방식
	// 주소 : http://localhost:9090/api/get/query-param2?name=홍길동&email=ten@naver.com&age=11&birth=19900824
	@GetMapping("/query-param2")
	public String queryParam1(@RequestParam Map<String, String> data) {

		StringBuilder sb = new StringBuilder();

		data.entrySet().forEach(entry -> {

			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println();

			sb.append(entry.getKey() + "=" + entry.getValue() + "\n");
		});

		return sb.toString();
	}
	
	// 3. DTO 방식
	// 일반적으로 많이 쓰이는 방식
	// 클라이언트 요청 ( B.W 전송 하면 B.R 로 받는다 ) ㅡ> 스프링의 어노테이션이 자동으로 처리해주고 있다. 
	// 주소 : http://localhost:9090/api/get/query-param3?name=홍길동&email=ten@naver.com&age=11&birth=19900824
	@GetMapping("query-param3")
	public String queryParam3(UserRequest request) {
		return request.toString();
	}
}
