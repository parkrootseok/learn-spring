package com.example.springstarthere.service;

import org.springframework.stereotype.Service;

import com.example.springstarthere.exception.NotEnoughMoneyException;
import com.example.springstarthere.model.PaymentDetails;

@Service
public class PaymentService {

	public PaymentDetails processPayment() throws NotEnoughMoneyException {
		throw new NotEnoughMoneyException();
	}

}
