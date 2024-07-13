package com.example.tobyspring;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException {
        PaymentService paymentService = new SimpleExchangeRatePaymentService();
        Payment payment = paymentService.prepare(100L, "USD", java.math.BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }

}
