package org.example.config;

import org.example.model.Parrot;
import org.example.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/**
 * @Configuration : Spring을 구성하는 클래스로 정의하기 위한 어노테이션
 * @ComponentScan : @Component를 명시한 클래스를 탐색할 것을 알려주기 위함
 * -> basePackages로 설정한 패키지에서 탐색
 */
@Configuration
@ComponentScan(basePackages = "org.example")
public class ProjectConfig {

    /**
     *
     * @Bean : 컨텍스트에 등록하기 위한 어노테이션
     *  -> 컨텍스트를 초기화 및 추가할 때 아래 어노테이션이 명시된 메소드를 호출해야할 것을 알려줌
     *  -> 메서드의 반환 값은 컨텍스트 반환
     * @Primary : Default Bean 등록
     * -> 이름을 명시하지 않고 Bean을 찾을 때 해당 어노테이션이 선언되어 있는 인스턴스를 찾음
     */
    @Bean
//    @Primary
    Parrot parrot() {

        // 앵무새 객체를 생성하고
        var p = new Parrot();

        // 이름을 코코로 설정한 후
        p.setName("코코");

        // 반환
        return p;

    }

    @Bean
    Person person(Parrot parrot2) {
        Person p = new Person();
        p.setName("루트");

//         Person - Parrot Bean 연결을 위해 직접 호출
//         Parrot 객체를 다시 생성하는 것이 아니라 컨텍스트에 있다면 인스턴스를 자동으로 참조
//         컨텍스트에 인스턴스가 없다면 Bean을 생성한 후 참조
//         p.setParrot(parrot());

//        // 컨텍스트에서 Parrot Bean을 찾아 주입(DI)
//        p.setParrot(parrot);

        // 변수명을 이용해 일치하는 @Bean을 찾아 주입
        p.setParrot(parrot2);
        return p;

    }

    /**
     * 동일한 클래스를 반환하는 여러 Bean 추가
     * Bean 이름은 메소드 이름으로 기본 사용되고
     * 이를 변경하기 위해서 name tag를 사용할 수 있음
     */
    @Bean
    Parrot parrot2() {

        // 앵무새 객체를 생성하고
        var p = new Parrot();

        // 이름을 코코로 설정한 후
        p.setName("미키");

        // 반환
        return p;

    }

    @Bean
    Parrot parrot3() {

        // 앵무새 객체를 생성하고
        var p = new Parrot();

        // 이름을 코코로 설정한 후
        p.setName("리키");

        // 반환
        return p;

    }

}
