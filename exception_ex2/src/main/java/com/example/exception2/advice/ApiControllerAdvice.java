package com.example.exception2.advice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception2.dto.CustomError;

@RestControllerAdvice
public class ApiControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		System.out.println("예외 발생 ! ");
		System.out.println("==========================");
		System.out.println(e.getClass());
		System.out.println("==========================");
		System.out.println(e.getMessage());
		System.out.println("==========================");
		System.out.println(e.getCause());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	// required로 정의된 프로퍼티가 없을때 (겟 방식 파라미터)
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e) {
		System.out.println("MissingServletRequestParameterException 에러가 발생 발생 ");
		
		// 앞에가 걸리면 뒤에거는 다 검사안함 
		String fieldName = e.getParameterName();
		String fieldType = e.getParameterType();
		String invalidValue = e.getMessage();
		
		System.out.println("fieldName : " + fieldName);
		System.out.println("fieldType : " + fieldType);
		System.out.println("invalidValue : " + invalidValue);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fieldName 을 입력해야 합니다 !");
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
		// 한번에 전부 들어온다.
		
		System.out.println("MethodArgumentNotValidException 예외발생 ! ");
		List<CustomError> errorList = new ArrayList<>();
		
		BindingResult bindingResult = e.getBindingResult();
		bindingResult.getAllErrors().forEach(action -> {
			FieldError field = (FieldError)action;
			
			String fieldName = field.getField();
			String fieldMassage = field.getDefaultMessage();
			
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMassage(fieldMassage);
			errorList.add(customError);
			
//			System.out.println("action : " + action.toString());
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
	
	// 겟방식의 validation 오류 
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException e) {
		// 동시에 확인 validation
		System.out.println("ConstraintViolationException 예외 발생 !");
		List<CustomError> errorList = new ArrayList<CustomError>();
		
		e.getConstraintViolations().forEach(error -> {
			
			String strField = error.getPropertyPath().toString();
			int index = strField.indexOf(".");
			String fieldName = strField.substring(index + 1);
			String message = error.getMessage();
			
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMassage(message);
			
			errorList.add(customError);
			
//			System.out.println(strField);
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
}
