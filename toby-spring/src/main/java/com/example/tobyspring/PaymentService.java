package com.example.tobyspring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class PaymentService {

    public Payment prepare(
            Long orderId, String currency, BigDecimal foreignCurrencyAmount
    ) throws IOException {

        /**
         *  todo: 환율 가져오기 (https://open.er-api.com/v6/latest/USD)
         */
        URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String response = br.lines().collect(Collectors.joining());
        br.close();

        System.out.println(response);

        // todo: 금액 계산
        // todo: 유효 시간 계산

        return new Payment(orderId, currency, foreignCurrencyAmount, BigDecimal.ZERO, BigDecimal.ZERO, LocalDateTime.now());
    }

    public static void main(String[] args) throws IOException {
        PaymentService paymentService = new PaymentService();
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }

}
