package org.example;

import java.util.function.Supplier;
import org.example.config.ProjectConfig;
import org.example.model.Parrot;
import org.example.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Component + @ComponentScan VS @Configuration + @Bean
 * @Component + @ComponentScan을 사용하는 것을 지양(더 적은 코드 작성)
 * Bean을 추가할 수 없을 경우(라이브러리의 일부 클래스일 때) @Configuration + @Bean 사용
 */
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
//        Parrot p1 = context.getBean("parrot1" , Parrot.class);
//        Parrot p2 = context.getBean("p2" , Parrot.class);
//        Parrot p3 = context.getBean("parrot3" , Parrot.class);
//
//        System.out.println("p1.getName() = " + p1.getName());
//        System.out.println("p2.getName() = " + p2.getName());
//        System.out.println("p3.getName() = " + p3.getName());

        /**
         * @Component를 통해 등록한 Bean 가져오기
         */
//        Parrot p2 = context.getBean(Parrot.class);
//        System.out.println("p2.getName() = " + p2.getName());

        /**
         * Programming 방식으로 Bean 등록
         * -> 조건을 통해 Bean으로 등록할 인스턴스를 유동적으로 선택할 수 있음
         * registerBean(Bean 이름, 추가하고 싶은 Class, 공급자의 인스턴스
         */

//        // Bean에 등록할 Parrot 클래스 인스턴스 생성하고 이를 반환하는 Supplier 정의
//        Parrot x = new Parrot();
//        x.setName("루트");
//        Supplier<Parrot> parrotSupplier = () -> x;
//
//        // Bean 등록
//        // bc -> bc.setPrimary(true) 기본 Bean으로 설정 (같은 타입을 반환하는 여러 빈이 있을때 primary가 표시된 빈이 우선적으로 선택됨
//        context.registerBean("parrot1", Parrot.class, parrotSupplier, bc -> bc.setPrimary(true));
//
//        // Bean 가져오기
//        Parrot p = context.getBean(Parrot.class);
//        System.out.println("p.getName() = " + p.getName());
        
        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("person = " + person.getName());
        System.out.println("person.getParrot() = " + person.getParrot());
        System.out.println("parrot.getName() = " + parrot.getName());


    }

}