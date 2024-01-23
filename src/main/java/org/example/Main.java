package org.example;

import org.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        /**
         * Spring Context 생성
         * -> 컨텍스트 인스턴스를 생성할 때 매개변수를 통해 이를 사용하도록 지정
         */
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        /**
         * Context에서 Parrot 클래스와 관련된 Bean을 가져온다.
         */
//        Parrot p = context.getBean(Parrot.class);

        /**
         * 만약, 동일한 클래스를 반환하는 @Bean이 존재한다면
         * 해당 Bean 이름(설정하지 않았다면 메소드 이름)과 함께 파라미터로 전달해 이를 가져온다.
         */
        Parrot p1 = context.getBean("parrot1" , Parrot.class);
        Parrot p2 = context.getBean("p2" , Parrot.class);
        Parrot p3 = context.getBean("parrot3" , Parrot.class);

        System.out.println("p1.getName() = " + p1.getName());
        System.out.println("p2.getName() = " + p2.getName());
        System.out.println("p3.getName() = " + p3.getName());

    }

}