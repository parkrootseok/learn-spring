package com.example.tobyspring;

import com.example.tobyspring.payment.ExchangeRateProvider;
import com.example.tobyspring.payment.ExchangeRateProviderStub;
import com.example.tobyspring.payment.PaymentService;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestPaymentConfig {

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(ExchangeRateProviderStub(), clock());
    }

    @Bean
    public ExchangeRateProvider ExchangeRateProviderStub() {
        return new ExchangeRateProviderStub(BigDecimal.valueOf(1_000));
    }

    @Bean
    public Clock clock() {
        return Clock.fixed(Instant.now(), ZoneId.systemDefault());
    }

}
