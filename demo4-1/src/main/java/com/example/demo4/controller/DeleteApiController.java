package com.example.demo4.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kimhyunah1")
public class DeleteApiController {
	
	// put 방식에서 사용하던 @RequestBody 랑 헷갈리지 말기 ( @RequestParam )

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable String id, @RequestParam String number) {
		System.out.println("삭제완료");
	}
}
