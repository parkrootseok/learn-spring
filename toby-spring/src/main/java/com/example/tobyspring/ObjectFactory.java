package com.example.tobyspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectFactory {

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(cachedExchangeRateProvider());
    }

    @Bean
    public ExchangeRateProvider webApiExchangeRateProvider() {
        return new WebApiExchangeRateProvider();
    }

    @Bean
    public ExchangeRateProvider simpleExchangeRateProvider() {
        return new SimpleExchangeRateProvider();
    }

    @Bean
    public ExchangeRateProvider cachedExchangeRateProvider() {
        return new CachedExchangeRateProvider(webApiExchangeRateProvider());
    }

}
