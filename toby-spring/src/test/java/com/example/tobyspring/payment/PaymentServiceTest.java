package com.example.tobyspring.payment;

import java.io.IOException;
import java.math.BigDecimal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {

    @Test
    void prepare() throws IOException {

        convertedAmount(BigDecimal.valueOf(5_00), BigDecimal.valueOf(5_000));
        convertedAmount(BigDecimal.valueOf(1_000), BigDecimal.valueOf(10_000));
        convertedAmount(BigDecimal.valueOf(3_000), BigDecimal.valueOf(30_000));

//        Assertions.assertThat(payment.getValidUtil()).isAfter(LocalDateTime.now());
//        Assertions.assertThat(payment.getValidUtil()).isBefore(LocalDateTime.now().plusMinutes(30));

    }

    private void convertedAmount(BigDecimal exchangeRate, BigDecimal convertedAmount) throws IOException {

        PaymentService paymentService = new PaymentService(new ExchangeRateProviderStub(exchangeRate));

        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        Assertions.assertThat(payment.getExhangeRate()).isEqualByComparingTo(exchangeRate);
        Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo((convertedAmount));

    }

}