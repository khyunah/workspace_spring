package com.example.demo3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarDto {

	private String name;
	
	// json 형식의 이름(" " )이 해당 변수에 접목된다는 어노테이션
	@JsonProperty("car_name")
	private String carName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	@Override
	public String toString() {
		return "CarDto [name=" + name + ", carName=" + carName + "]";
	}

}
