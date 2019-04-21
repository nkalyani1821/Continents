package com.continents.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.continents.utils.ObjectNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ExceptionHandlerExceptionResolver {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<?> handleObjectNotFoundException(ObjectNotFoundException ex) {
		return ResponseEntity.badRequest().body(ex.getLocalizedMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getLocalizedMessage());
	}
	
}
