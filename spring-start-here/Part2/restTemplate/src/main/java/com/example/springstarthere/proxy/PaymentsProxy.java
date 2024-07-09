package com.example.springstarthere.proxy;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.springstarthere.model.Payment;

@Component
public class PaymentsProxy {

	private final RestTemplate restTemplate;

	@Value("${name.service.url}")
	private String paymentServiceUrl;

	public PaymentsProxy(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Payment createPayment(Payment payment) {

		String uri  = paymentServiceUrl + "/payment";

		// header 설정
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("requestId", UUID.randomUUID().toString());

		// Request에 담을 데이터 설정
		HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, httpHeaders);

		// Http 요청
		ResponseEntity<Payment> response
			= restTemplate.exchange(uri, HttpMethod.POST, httpEntity, Payment.class);

		// Response에 담긴 데이터 반환
		return response.getBody();

	}

}
