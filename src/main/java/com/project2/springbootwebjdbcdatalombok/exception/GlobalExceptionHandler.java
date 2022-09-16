package com.project2.springbootwebjdbcdatalombok.exception;

import java.awt.Button;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.context.Theme;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		Map<String, String> errorsMap = new HashMap<String,String>(); //this hashmap will hold all the validation error messages
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldString = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			errorsMap.put(fieldString, errorMessage);
		});
		
		//now the hashmap errors has all the field names and it's corresponding
		//error messages
		//return the hasmap by enclosing it in a response entity
		return new ResponseEntity<Object>(errorsMap, HttpStatus.BAD_REQUEST);
		
		//go ahead and handle custom exceptions
		//need to use exception handler
	}

	
}
