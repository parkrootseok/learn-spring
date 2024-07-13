package com.example.tobyspring;

import com.fasterxml.jackson.databind.ObjectMapper;
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

        BigDecimal exchangeRate = getExchangeRate(currency);
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exchangeRate);
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(orderId, currency, foreignCurrencyAmount, exchangeRate, convertedAmount, validUntil);

    }

    private BigDecimal getExchangeRate(String currency) throws IOException {
        URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String response = br.lines().collect(Collectors.joining());
        br.close();

        ObjectMapper mapper = new ObjectMapper();
        ExchangeRateVO exchangeRateVO = mapper.readValue(response, ExchangeRateVO.class);
        BigDecimal exchangeRate = exchangeRateVO.rates().get("KRW");
        return exchangeRate;
    }

    public static void main(String[] args) throws IOException {
        PaymentService paymentService = new PaymentService();
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }

}
