package com.example.demo2_1.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2_1.models.UserDto;

@RestController
@RequestMapping("/kimhyunah/220530")
public class GetApiController {

	// 주소 ㅡ> http://localhost:9091/kimhyunah/220530/info
	@GetMapping("/info")
	public String getInfo() {
		return "name : kimhyunah / age : 20 / address : 서울";
	}

	/**
	 * PathVariable 방식
	 * 
	 * 이방식은 정해진 주소로만 요청할 수 있어서 다른 값을 적으면 오류가 난다.
	 * 
	 */
	// 주소 ㅡ> http://localhost:9091/kimhyunah/220530/{job}
	@GetMapping("/{job}")
	public String queryParamJob(@PathVariable(name = "job") String job) {
		return "job : " + job;
	}

	/**
	 * Query Parameter 방식
	 * 
	 * 1. key 값으로 받는다.
	 * 
	 */
	// 주소 ㅡ>
	// http://localhost:9091/kimhyunah/220530/path-key?name=김현아&age=10&address=부산
	@GetMapping("/path-key")
	public String getInfo2(@RequestParam String name, @RequestParam int age, @RequestParam String address) {
		return "name : " + name + ", age : " + age + ", address : " + address;
	}

	/**
	 * Query Parameter 방식
	 * 
	 * 2. Map 형식으로 받는다.
	 */
	// 주소 ㅡ>
	// http://localhost:9091/kimhyunah/220530/path-map?name=김현아&age=10&address=부산
	@GetMapping("/path-map")
	public String getInfo3(@RequestParam Map<String, String> data) {

		StringBuilder builder = new StringBuilder();

		data.entrySet().forEach(entry -> {
			builder.append(entry.getKey() + "=" + entry.getValue() + "\n");
		});

		return builder.toString();
	}

	/**
	 * Query Parameter 방식
	 * 
	 * 3. DTO 형식으로 받는다.
	 */
	// 주소 ㅡ>
	// http://localhost:9091/kimhyunah/220530/path-dto?name=김현아&age=10&address=부산
	@GetMapping("/path-dto")
	public String getInfo4(UserDto userDto) {
		return userDto.toString();
	}

}
