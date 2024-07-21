package com.example.tobyspring.payment;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

public class PaymentService {

    private final ExchangeRateProvider exchangeRateProvider;
    private final Clock clock;

    public PaymentService(ExchangeRateProvider exchangeRateProvider, Clock clock) {
        this.exchangeRateProvider = exchangeRateProvider;
        this.clock = clock;
    }

    public Payment prepare(
            Long orderId, String currency, BigDecimal foreignCurrencyAmount
    ) throws IOException {

        BigDecimal exchangeRate = exchangeRateProvider.getExchangeRate(currency);
        return Payment.createPrepared(orderId, currency, foreignCurrencyAmount, exchangeRate, LocalDateTime.now(clock));

    }

}
