package org.example.config;

import org.example.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration // Spring을 구성하는 클래스로 정의하기 위한 어노테이션
public class ProjectConfig {

    /**
     * @Bean : 컨텍스트에 등록하기 위한 어노테이션
     *  -> 컨텍스트를 초기화 및 추가할 때 아래 어노테이션이 명시된 메소드를 호출해야할 것을 알려줌
     *  -> 메서드의 반환 값은 컨텍스트 반환
     */
    @Bean
    Parrot parrot() {

        // 앵무새 객체를 생성하고
        var p = new Parrot();

        // 이름을 코코로 설정한 후
        p.setName("코코");

        // 반환
        return p;

    }

    /**
     * Spring Context에 문자열 Hello, 숫자 10 추가
     */
    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    int ten() {
        return 10;
    }


}
