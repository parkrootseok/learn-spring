package com.example.springstarthere.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.springstarthere.model.ErrorDetails;

@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(NotEnoughMoneyException.class)
	public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler() {

		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage("Not Enough Money");
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(errorDetails);

	}

}
