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

    /**
     * 1. api 요청을 통해 얻어온 response를 ObjectMapper를 통해 ExchangeRateVO 객체에 저장
     * 2. 저장된 Data에서 환율을 가져온 후 계산
     * 3. 유효 시간을 설정
     */
    public Payment prepare(
            Long orderId, String currency, BigDecimal foreignCurrencyAmount
    ) throws IOException {


        // 1
        URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String response = br.lines().collect(Collectors.joining());
        br.close();

        // 2
        ObjectMapper mapper = new ObjectMapper();
        ExchangeRateVO exchangeRateVO = mapper.readValue(response, ExchangeRateVO.class);
        BigDecimal exchangeRate = exchangeRateVO.rates().get("KRW");
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exchangeRate);

        // 3
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(orderId, currency, foreignCurrencyAmount, exchangeRate, convertedAmount, validUntil);
    }

    public static void main(String[] args) throws IOException {
        PaymentService paymentService = new PaymentService();
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }

}
