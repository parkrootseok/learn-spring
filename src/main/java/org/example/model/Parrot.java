package org.example.model;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 스테레오타입 주석을 이용해 Bean 등록
 * @Component : Spring Context에 등록하고 싶은 클래스에 명시
 */
@Component
public class Parrot {

    private String name;

    public Parrot() {
        this.name = "SSAFY";
        System.out.println("Parrot Created!");
    }

    /**
     * @PostConstruct : 객체 생성 후 해당 메소드를 호출하도록 지시하기 위함
     */    @PostConstruct
//    void init() {
//        this.name = "ROOT";
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot {" +
                "name='" + name + '\'' +
                '}';
    }

}
