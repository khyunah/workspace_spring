package com.example.filter_ex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

	@GetMapping("/get")
	public String get() {
		log.info("겟 방식으로 요청 확인");
		return "get ok";
	}
}
