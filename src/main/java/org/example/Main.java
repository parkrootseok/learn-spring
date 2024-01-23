package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        // Spring Context 생성
        var context = new AnnotationConfigApplicationContext();

        Parrot p = new Parrot();

    }
}