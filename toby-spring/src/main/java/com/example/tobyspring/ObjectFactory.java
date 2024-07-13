package com.example.tobyspring;

public class ObjectFactory {

    public PaymentService paymentService() {
        return new PaymentService(exchangeRateProvider());
    }

    public ExchangeRateProvider exchangeRateProvider() {
        return new WebApiExchangeRateProvider();
    }

}
