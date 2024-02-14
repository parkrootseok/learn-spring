package org.example.chap6.aspects;

import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    /**
     * @Around 어노테이션을 활용해 어떤 메소드를 언제 가로챌지 명시
     * AspectJ Pointcut 표현식을 통해 이를 명시
     * execution() = ()안에 명시되어 있는 메소드가 호출될때 실행하겠다
     * () 안에는 실행을 가로챌 메소드에 대해 명시
     * -> (*[리턴 타입 상관없이] services[패키지 안에].*[모든 클래스에서].*[모든 메소드에 대해].(..)[파라미터 상관없이])
     */
    @Around("execution(* org.example.chap6.services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {

        // 메소드가 실행되기 전 메시지
        logger.info("메소드 실행");

        // 인터셉터 메소드 호출
        // 아래를 코드를 수행하지 않으면 실제 메서드는 호출되지 않음
        joinPoint.proceed();

        // 인터셉터 메소드 실행 후 메시지
        logger.info("실행된 메소드");

    }


}
