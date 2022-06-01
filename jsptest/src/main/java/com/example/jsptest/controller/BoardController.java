package com.example.jsptest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	// http://localhost:8000/board/index
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	// http://localhost:8000/board/home
	
	// 내부적으로 우리가 설정해놓은 값때문에 위의 주소를 찾아가지만 
	// 실제주소는 밑에 주소임.
	// http://localhost:8000/board/WEB-INF/views/home.jsp
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
