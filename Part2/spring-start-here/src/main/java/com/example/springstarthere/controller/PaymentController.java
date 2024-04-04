package com.example.springstarthere.controller;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.springstarthere.model.Payment;
import com.example.springstarthere.service.PaymentService;

@RestController
public class PaymentController {

	private static Logger logger = Logger.getLogger(PaymentController.class.getName());
	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping("/payment")
	public ResponseEntity<Payment> createPayment(
		@RequestHeader String requestId,
		@RequestBody Payment payment) {

		logger.info("Received request with ID " + requestId + " ;Payment Amount: " + payment.getAmount());

		payment.setId(UUID.randomUUID().toString());

		return ResponseEntity
			.status(HttpStatus.OK)
			.header("requestId", requestId)
			.body(payment);

	}

}
