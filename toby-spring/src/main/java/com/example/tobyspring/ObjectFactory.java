package com.example.tobyspring;

import com.example.tobyspring.exchangerate.CachedExchangeRateProvider;
import com.example.tobyspring.payment.ExchangeRateProvider;
import com.example.tobyspring.exchangerate.SimpleExchangeRateProvider;
import com.example.tobyspring.exchangerate.WebApiExchangeRateProvider;
import com.example.tobyspring.payment.PaymentService;
import java.time.Clock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectFactory {

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(webApiExchangeRateProvider(), clock());
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

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

}
