package com.example.tobyspring;

import com.example.tobyspring.payment.ExchangeRateProvider;
import com.example.tobyspring.payment.ExchangeRateProviderStub;
import com.example.tobyspring.payment.PaymentService;
import java.math.BigDecimal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestObjectFactory {

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(ExchangeRateProviderStub());
    }

    @Bean
    public ExchangeRateProvider ExchangeRateProviderStub() {
        return new ExchangeRateProviderStub(BigDecimal.valueOf(1_000));
    }

}
