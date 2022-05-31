package com.example.validation1.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
	
	@JsonProperty("student_number")
	private int studentNumber;
	
	@NotBlank(message = "이름을 입력하세요.")
	private String name;
	
	@Max(value = 4, message = "4학년까지 입력가능 합니다.")
	@Min(value = 1, message = "1학년부터 입력가능 합니다.")
	private int grade;
	
	@Email
	private String email;

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + ", name=" + name + ", grade=" + grade + ", email=" + email
				+ "]";
	}

}
