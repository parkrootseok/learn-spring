package com.example.tobyspring.payment;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import org.springframework.cglib.core.Local;

public class Payment {

    private Long orderId;
    private String currency;
    private BigDecimal foreignCurrencyAmount;    // double, float 형을 사용할 경우 데이터 손실 위험이 있으므로 BigDecimal 사용
    private BigDecimal exchangeRate;
    private BigDecimal convertedAmount;
    private LocalDateTime validUtil;

    public Payment(
            Long orderId,
            String currency,
            BigDecimal foreignCurrencyAmount,
            BigDecimal exchangeRate,
            BigDecimal convertedAmount,
            LocalDateTime validUtil
    ) {
        this.orderId = orderId;
        this.currency = currency;
        this.foreignCurrencyAmount = foreignCurrencyAmount;
        this.exchangeRate = exchangeRate;
        this.convertedAmount = convertedAmount;
        this.validUtil = validUtil;
    }

    public static Payment createPrepared(
            Long orderId,
            String currency,
            BigDecimal foreignCurrencyAmount,
            BigDecimal exchangeRate,
            LocalDateTime now
            ) {

        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exchangeRate);
        LocalDateTime validUntil = now.plusMinutes(30);

        return new Payment(orderId, currency, foreignCurrencyAmount, exchangeRate, convertedAmount, validUntil);

    }

    public boolean isValid(Clock clock) {
        return LocalDateTime.now(clock).isBefore(this.validUtil);
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getForeignCurrencyAmount() {
        return foreignCurrencyAmount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public LocalDateTime getValidUtil() {
        return validUtil;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId=" + orderId +
                ", currency='" + currency + '\'' +
                ", foreignCurrencyAmount=" + foreignCurrencyAmount +
                ", exRate=" + exchangeRate +
                ", convertedAmount=" + convertedAmount +
                ", validUtil=" + validUtil +
                '}';
    }

}
