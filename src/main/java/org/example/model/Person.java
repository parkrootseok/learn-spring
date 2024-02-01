package org.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Autowired를 사용하기 위해 @Component를 사용해 컨텍스트에 등록
 */
@Component
public class Person {

    private String name;

    // has-a(Person has a Parrot) 관계
    /**
     * @Autowired : Spring Context에서 값을 주입하도록 컴파일러에게 알리기 위한 어노테이션
     * -> 클래스 필드에 값을 주입하는 방법
     * */
//    @Autowired
    private Parrot parrot;

    public Person() {}

    /**
     * 생성자를 호출할 때 자동으로 Parrot 주입
     * Parrot에 대한 멤버변수는 final로 선언하여 초기화 후 변경 불가(불변성)
     * @param parrot
     */
//    @Autowired
//    public Person(Parrot parrot) {
//        this.parrot = parrot;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    /**
     * setter를 이용하여 주입
     * @param parrot
     */
//    @Autowired
    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

}
