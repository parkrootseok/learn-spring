package org.example.chap6.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Retention : 보존 정책을 정의하기 위한 어노테이션
 * -> 기본적으로 Runtime 시 가로챌 수 없지만 어노테이션을 통해 명시적으로 지정
 * @Target : 주석을 사용할 수 있는 요소를 지정하기 위한 어노테이션
 * -> 아래 어노테이션의 경우 METHOD로 한정
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ToLog {

}
