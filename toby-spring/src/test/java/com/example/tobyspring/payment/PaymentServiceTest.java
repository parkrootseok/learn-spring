package com.example.tobyspring.payment;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {

    Clock clock;

    @BeforeEach
    void beforeEach() {
        this.clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    }

    @Test
    void testAmount() throws IOException {

        testAmount(BigDecimal.valueOf(5_00), BigDecimal.valueOf(5_000));
        testAmount(BigDecimal.valueOf(1_000), BigDecimal.valueOf(10_000));
        testAmount(BigDecimal.valueOf(3_000), BigDecimal.valueOf(30_000));

    }

    private void testAmount(BigDecimal exchangeRate, BigDecimal convertedAmount) throws IOException {

        PaymentService paymentService = new PaymentService(new ExchangeRateProviderStub(exchangeRate), this.clock);

        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        Assertions.assertThat(payment.getExhangeRate()).isEqualByComparingTo(exchangeRate);
        Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo((convertedAmount));

    }

    @Test
    void validUntil() throws IOException {

        PaymentService paymentService = new PaymentService(new ExchangeRateProviderStub(BigDecimal.valueOf(1_000)), this.clock);
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        LocalDateTime now = LocalDateTime.now(this.clock);
        LocalDateTime expectedValidUntil = now.plusMinutes(30);

        Assertions.assertThat(payment.getValidUtil()).isEqualTo(expectedValidUntil);

    }

}