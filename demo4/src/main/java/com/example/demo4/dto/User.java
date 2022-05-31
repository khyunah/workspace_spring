package com.example.demo4.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * { "name" : "aaa", "age" : 30, "phone_number" : "010-1212-1212", "address" :
 * "부산시 해운대구 우동" }
 */
// @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {

	private String name;
	private int age;
	@JsonProperty("phone_number")
	private String phoneNumber;
	private String address;

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

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}

	
}
