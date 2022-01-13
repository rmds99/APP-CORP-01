package com.imposto_de_renda.controller.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.imposto_de_renda.service.exceptions.DataIntegratyViolationException;
import com.imposto_de_renda.service.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler 
{
	//http://localhost:8080/swagger-ui.html
	@ExceptionHandler(DataIntegratyViolationException.class)
	public ResponseEntity<StanderError> dataIntegratyViolation(DataIntegratyViolationException ex, HttpServletRequest request)
	{
		StanderError error = new StanderError(LocalDateTime.now(), ex.getMessage(), request.getRequestURI(), HttpStatus.BAD_REQUEST.value());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StanderError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request)
	{
		StanderError error = new StanderError(LocalDateTime.now(), ex.getMessage(), request.getRequestURI(), HttpStatus.NOT_FOUND.value());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
