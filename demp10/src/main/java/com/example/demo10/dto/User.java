package com.example.demo10.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	private String name;
	private Integer age;
	private String url;
	
	// 샘플 데이터
	public static List<User> sampleUser(){
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("홍길동1", 11, "http://localhost:9090/abc.jpg"));
		list.add(new User("홍길동2", 12, "http://localhost:9090/abc.jpg"));
		list.add(new User("홍길동3", 13, "http://localhost:9090/abc.jpg"));
		list.add(new User("홍길동4", 14, "http://localhost:9090/abc.jpg"));
		return list;
	}
	// 정적인 이미지는 static 폴더에 넣는다. 이폴더는 주소로 접근이 가능하다. ( 설정을 통해 막을수 있음 )

}
