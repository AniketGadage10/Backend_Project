package com.app.Gobalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.DTO.Apiresponse;
import com.app.exception.Addmissionexception;

@RestControllerAdvice
public class GobalException {

	@ExceptionHandler(Addmissionexception.class)
	public ResponseEntity<?> addmissionexception(Addmissionexception a) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new Apiresponse(a.getMessage()));
	}
}
