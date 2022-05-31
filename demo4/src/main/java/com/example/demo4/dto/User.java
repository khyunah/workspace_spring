package com.example.demo4.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * { "name" : "aaa", "age" : 30, "phone_number" : "010-1212-1212", "address" :
 * "부산시 해운대구 우동" }
 */
// @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)

// null값을 내려주고 싶지 않을때 사용 ( null이면 값이 포함되어 가지 않음 )
// 하지만 실무에서 많이 사용하는 것은 아님. ( 때에따라 null 있고 없으면 더 불편 )
@JsonInclude(JsonInclude.Include.NON_NULL)	
public class User {

	private String name;
	private int age;
	@JsonProperty("phone_number")
	private String phoneNumber;
	private String address;
	private String idNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
}
