package com.example.tobyspring;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {

        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);
        PaymentService paymentService = beanFactory.getBean(PaymentService.class);

        Payment payment1 = paymentService.prepare(100L, "USD", java.math.BigDecimal.valueOf(50.7));
        System.out.println("Payment1: " + payment1);

        System.out.println("---------------------------------------------------");

        TimeUnit.SECONDS.sleep(1);
        Payment payment2 = paymentService.prepare(100L, "USD", java.math.BigDecimal.valueOf(50.7));
        System.out.println("Payment2: " + payment2);

        System.out.println("---------------------------------------------------");

        TimeUnit.SECONDS.sleep(3);
        Payment payment3 = paymentService.prepare(100L, "USD", java.math.BigDecimal.valueOf(50.7));
        System.out.println("Payment3: " + payment3);


    }

}
