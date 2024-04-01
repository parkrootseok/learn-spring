package com.example.springstarthere.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springstarthere.exception.NotEnoughMoneyException;
import com.example.springstarthere.model.ErrorDetails;
import com.example.springstarthere.model.PaymentDetails;
import com.example.springstarthere.service.PaymentService;

@RestController
public class PaymentController {

	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping("/payment")
	public ResponseEntity<?> makePayment() {

		try {
			PaymentDetails paymentDetails = paymentService.processPayment();

			return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(paymentDetails);

		} catch (NotEnoughMoneyException e) {
			ErrorDetails errorDetails = new ErrorDetails();
			errorDetails.setMessage("Not Enough Money");
			return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(errorDetails);
		}

	}

}
