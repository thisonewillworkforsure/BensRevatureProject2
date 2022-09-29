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
		Map<String, String> errorsMap = new HashMap<String,String>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldString = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			errorsMap.put(fieldString, errorMessage);
		});
		
		
		return new ResponseEntity<Object>(errorsMap, HttpStatus.BAD_REQUEST);
		
	
	}

	
}
