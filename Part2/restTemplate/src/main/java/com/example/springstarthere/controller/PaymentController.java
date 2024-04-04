package com.example.springstarthere.controller;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springstarthere.model.Payment;
import com.example.springstarthere.proxy.PaymentsProxy;

@RestController
public class PaymentController {

	private static Logger logger = Logger.getLogger(PaymentController.class.getName());
	private final PaymentsProxy paymentProxy;

	public PaymentController(PaymentsProxy paymentProxy) {
		this.paymentProxy = paymentProxy;
	}

	@PostMapping("/payment")
	public Payment createPayment(@RequestBody Payment payment) {

		String requestId = UUID.randomUUID().toString();
		logger.info("Received request with ID " + requestId + " ;Payment Amount: " + payment.getAmount());

		/**
		 * paymentProxy를 이용하여 현재 서버의 엔드 포인트로 들어온 요청을 다른 서버의 엔드 포인트를 호출하여 이동
		 */
		return paymentProxy.createPayment(payment);

	}

}
