package com.example.tobyspring.payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {

    private Long orderId;

    private String currency;

    // double, float 형을 사용할 경우 데이터 손실 위험이 있으므로 BigDecimal 사용
    private BigDecimal foreignCurrencyAmount;

    private BigDecimal exhangeRate;

    private BigDecimal convertedAmount;

    private LocalDateTime validUtil;

    public Long getOrderId() {
        return orderId;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getForeignCurrencyAmount() {
        return foreignCurrencyAmount;
    }

    public BigDecimal getExhangeRate() {
        return exhangeRate;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public LocalDateTime getValidUtil() {
        return validUtil;
    }

    public Payment(
            Long orderId,
            String currency,
            BigDecimal foreignCurrencyAmount,
            BigDecimal exhangeRate,
            BigDecimal convertedAmount,
            LocalDateTime validUtil
    ) {
        this.orderId = orderId;
        this.currency = currency;
        this.foreignCurrencyAmount = foreignCurrencyAmount;
        this.exhangeRate = exhangeRate;
        this.convertedAmount = convertedAmount;
        this.validUtil = validUtil;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId=" + orderId +
                ", currency='" + currency + '\'' +
                ", foreignCurrencyAmount=" + foreignCurrencyAmount +
                ", exRate=" + exhangeRate +
                ", convertedAmount=" + convertedAmount +
                ", validUtil=" + validUtil +
                '}';
    }

}
