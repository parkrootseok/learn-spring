package com.example.tobyspring.exchangerate;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CachedExchangeRateProvider implements ExchangeRateProvider {

    private final ExchangeRateProvider target;
    private BigDecimal cachedExchangeRate;
    private LocalDateTime cacheExpirationTime;

    public CachedExchangeRateProvider(ExchangeRateProvider target) {
        this.target = target;
    }

    @Override
    public BigDecimal getExchangeRate(String currency) throws IOException {

        if (cachedExchangeRate == null || LocalDateTime.now().isAfter(cacheExpirationTime)) {
            cachedExchangeRate = this.target.getExchangeRate(currency);
            cacheExpirationTime = LocalDateTime.now().plusSeconds(3);
            System.out.println("Cache Updated");
        }

        return cachedExchangeRate;

    }

}
