package com.example.tobyspring.payment;

import com.example.tobyspring.TestPaymentConfig;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestPaymentConfig.class)
class PaymentServiceSpringTest {

    @Autowired
    PaymentService paymentService;

    @Autowired
    Clock clock;

    @Autowired
    ExchangeRateProviderStub exchangeRateProviderStub;

    @Test
    void convertedAmount() throws IOException {

        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);
        Assertions.assertThat(payment.getExhangeRate()).isEqualByComparingTo(BigDecimal.valueOf(1_000));
        Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(BigDecimal.valueOf(10_000));

        exchangeRateProviderStub.setExchangeRate(BigDecimal.valueOf(500));
        payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);
        Assertions.assertThat(payment.getExhangeRate()).isEqualByComparingTo(BigDecimal.valueOf(500));
        Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(BigDecimal.valueOf(5_000));

    }

    @Test
    void validUntil() throws IOException {

        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        LocalDateTime now = LocalDateTime.now(this.clock);
        LocalDateTime expectedValidUntil = now.plusMinutes(30);

        Assertions.assertThat(payment.getValidUtil()).isEqualTo(expectedValidUntil);

    }

}