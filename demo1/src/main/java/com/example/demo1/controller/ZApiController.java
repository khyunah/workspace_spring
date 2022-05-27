package com.example.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * RestController 
 * : Controller와 ResponseBody가 결합된 어노테이션
 * 해당 클래스의 하위 메서드에 따로 붙여주지 않아도, 
 * 문자열과 JSON형식을 전송할 수 있다. 
 * 
 * Controller 
 * : Spring의 MVC 모델 이라는 프레임워크가 있다. 
 * MVC 에서 C에 해당하며, 
 * 사용자의 요청을 처리한 후 지정된 뷰에 모델 객체를 넘겨주는 역할을 한다.
 * 
 * ResponseBody
 * : http 요청의 본문 body 부분이 그대로 전달된다. 
 * 자바 객체를 HTTP 응답 바디 ( JSON형식 )으로 바꿔주는 역할을 한다.
 */
@RestController

/*
 * RequestMapping : 요청에 대해 어떤 Controller, 어떤 메소드를 처리할지를 묶어주는 어노테이션
 * RequestMapping("/주소/..") 이런식으로 사용한다.
 */
@RequestMapping("/abcde")
public class ZApiController {

	// 주소 : http://localhost:8080/abcde/hello
	@GetMapping("/hello")
	public String getHello() {
		return "sayHello";
	}

	/*
	 * GetMapping : GET 방식 일때는 URI 방식을 사용한다. ( 데이터를 담아서 요청할 수 있음 ㅡ> 응답을 해줄 수 있다.) 괄호
	 * 안에 문자열로 주소체계가 잡힌다.
	 */
	// 주소 : http://localhost:8080/abcde/aabbcc/입력하는데이터값
	@GetMapping(path = "/aabbcc/{data}") // {data} : 템플릿 변수 라고 한다.
	public String queryParam(@PathVariable(name = "data") String data) {
		return "사용자가 입력해서 들어온 값 data : " + data;
	}

	// 주소 : http://localhost:8080/abcde/two-data/입력하는 데이터값1/입력하는 데이터값2
	@GetMapping(path = "/two-data/{data1}/{data2}")
	public String queryParam2(@PathVariable(name = "data1") String data1, @PathVariable(name = "data2") String data2) {
		return "data1 : " + data1 + ", data2 : " + data2;
	}

}
