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
        Parrot p = context.getBean(Parrot.class);

        /**
         * 객체에 대한 생성 및 설정을 하지 않았지만
         * ProjectConfig 클래스에서 추가된 Bean이 존재하기 때문에 이름이 존재
         */
        System.out.println("p.getName() = " + p.getName());

        /**
         * Context에 등록한 Bean을 불러와 등록 확인
         */
        System.out.println(context.getBean(String.class));
        System.out.println(context.getBean(Integer.class));

    }

}