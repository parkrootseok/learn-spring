package com.example.springstarthere.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springstarthere.model.PaymentDetails;
import com.example.springstarthere.service.PaymentService;

@RestController
public class PaymentController {

	private static Logger logger = Logger.getLogger(PaymentController.class.getName());
	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping("/payment")
	public ResponseEntity<?> makePayment(
		@RequestBody PaymentDetails paymentDetails
	) {

		logger.info("결제 완료 " + paymentDetails.getAmount());

		return ResponseEntity
			.status(HttpStatus.ACCEPTED)
			.body(paymentDetails);

	}

}
