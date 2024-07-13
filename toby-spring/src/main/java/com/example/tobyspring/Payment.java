package com.example.tobyspring;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {

    private Long orderId;

    private String currency;

    // double, float 형을 사용할 경우 데이터 손실 위험이 있으므로 BigDecimal 사용
    private BigDecimal foreignCurrencyAmount;

    private BigDecimal exRate;

    private BigDecimal convertedAmount;

    private LocalDateTime validUtil;

    public Payment(
            Long orderId,
            String currency,
            BigDecimal foreignCurrencyAmount,
            BigDecimal exRate,
            BigDecimal convertedAmount,
            LocalDateTime validUtil
    ) {
        this.orderId = orderId;
        this.currency = currency;
        this.foreignCurrencyAmount = foreignCurrencyAmount;
        this.exRate = exRate;
        this.convertedAmount = convertedAmount;
        this.validUtil = validUtil;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId=" + orderId +
                ", currency='" + currency + '\'' +
                ", foreignCurrencyAmount=" + foreignCurrencyAmount +
                ", exRate=" + exRate +
                ", convertedAmount=" + convertedAmount +
                ", validUtil=" + validUtil +
                '}';
    }

}
