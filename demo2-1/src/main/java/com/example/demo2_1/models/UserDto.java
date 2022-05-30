package com.example.demo2_1.models;

public class UserDto {

	private String name;
	private String address;
	private int age;
	
	@Override
	public String toString() {
		return "UserDto [name=" + name + ", address=" + address + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
