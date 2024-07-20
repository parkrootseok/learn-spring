package com.example.tobyspring.payment;

import java.io.IOException;
import java.math.BigDecimal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestObjectFactory.class)
class PaymentServiceSpringTest {

    @Autowired
    PaymentService paymentService;

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

}