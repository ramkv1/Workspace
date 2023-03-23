package com.rk.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rk.error.ErrorDetails;
import com.rk.exception.DoctorNotFoundException;

@RestControllerAdvice
public class DoctorServiceErrorHandlerAdvice {
	
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleDoctorNotFound(DoctorNotFoundException dnfe){
		ErrorDetails details=new ErrorDetails();
		details.setDateTime(LocalDateTime.now());
		details.setMessage(dnfe.getMessage());
		details.setStatus("404-Doctor Not found");
		
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleDoctorNotFound(Exception dnfe){
		ErrorDetails details=new ErrorDetails();
		details.setDateTime(LocalDateTime.now());
		details.setMessage(dnfe.getMessage());
		details.setStatus("404-Doctor Not found");
		
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
