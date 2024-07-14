package com.example.tobyspring.exchangerate;

import java.io.IOException;
import java.math.BigDecimal;

public interface ExchangeRateProvider {

    BigDecimal getExchangeRate(String currency) throws IOException;

}
