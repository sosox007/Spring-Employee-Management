package com.giantlink.grh.controllers.advices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.ResourceNotFoundException;



@RestControllerAdvice
public class CompanyExceptionHandler {

	// MethodArgumentNotValidException

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInput(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<String, String>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		return errors;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public Map<String, String> handleInput(ResourceNotFoundException ex) {
		Map<String, String> errors = new HashMap<String, String>();
		errors.put(ResourceNotFoundException.class.getSimpleName(), ex.getMessage());
		return errors;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AlreadyExistsException.class)
	public Map<String, String> handleInput(AlreadyExistsException ex) {
		Map<String, String> errors = new HashMap<String, String>();
		errors.put(ex.getObject(), ex.getMessage());
		return errors;
	}
}
