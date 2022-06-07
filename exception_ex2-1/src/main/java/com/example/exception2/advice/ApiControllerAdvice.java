package com.example.exception2.advice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception2.dto.MyError;

@RestControllerAdvice
public class ApiControllerAdvice {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception 오류 발생 했습니당 ! ! ");
	}

	// 겟방식의 validation 오류
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException (ConstraintViolationException e){
		List<MyError> errorList = new ArrayList<MyError>();
		
		e.getConstraintViolations().forEach(action -> {
		
			MyError myError = new MyError();
			
			int index = (action.getPropertyPath().toString()).indexOf(".");
			String errorField = (action.getPropertyPath().toString()).substring(index + 1);
			
			myError.setErrorField(errorField);
			myError.setErrorMessage(action.getMessage());
			
			errorList.add(myError);
			
		});
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorList);
	}
	
	// 겟방식의 파라미터값이 없는 오류
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e){
		List<MyError> errorList = new ArrayList<MyError>();
		MyError myError = new MyError();
		myError.setErrorField(e.getParameterName());
		myError.setErrorMessage(e.getParameterType() + " / " + e.getMessage());
		errorList.add(myError);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
	
	// 포스트방식의 바디부분에 JSON 형식이 잘못 되었을 때
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity<?> httpMessageNotReadableException(HttpMessageNotReadableException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("HttpMessageNotReadableException 오류가 발생했음 ! ! ");
	}
	
	// 포스트방식의 바디부분에 필드가 없을때
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
		List<MyError> errorList = new ArrayList<MyError>();
		
		e.getBindingResult().getAllErrors().forEach(action -> {
			MyError myError = new MyError();
			
			FieldError fieldError = (FieldError) action;
			
			myError.setErrorField(fieldError.getField());
			myError.setErrorMessage(action.getDefaultMessage());
			errorList.add(myError);
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
}
