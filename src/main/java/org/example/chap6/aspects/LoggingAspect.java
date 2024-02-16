package org.example.chap6.aspects;

import java.util.Arrays;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.chap6.Comment;

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
//    @Around("execution(* org.example.chap6.services.*.*(..))")
//    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        // 메소드가 실행되기 전 메시지
//        logger.info("메소드 실행");
//
//        // 인터셉터 메소드 호출
//        // 아래를 코드를 수행하지 않으면 실제 메서드는 호출되지 않음
//        joinPoint.proceed();
//
//        // 인터셉터 메소드 실행 후 메시지
//        logger.info("실행된 메소드");
//
//    }

    /**
     * 인터셉터한 메소드에 대한 파라미터, 반환값을 변경하여 실행
     */
//    @Around("execution(* org.example.chap6.services.*.*(..))")
//    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        // 인터셉트한 메소드 이름 얻기
//        String methodName = joinPoint.getSignature().getName();
//
//        // 인터셉트한 메소드의 매개변수 얻기
//        Object[] arguments = joinPoint.getArgs();
//
//        logger.info("Method " + methodName + " with parameters " + Arrays.asList(arguments) + " will execute");
//
//        // 파라미터 변경 전 호출
//        joinPoint.proceed();
//
//        // 기존에 메소드에서 사용하는 파라미터를 새롭게 교체
//        Comment comment = new Comment();
//        comment.setText("Different Text");
//        Object[] newArguments = {comment};
//
//        // 인터셉트 메소드 반환값 얻기
//        Object returnByMethod = joinPoint.proceed(newArguments);
//
//        logger.info("Method executed and returned " + returnByMethod);
//
//        // 인터셉터 한 메소드가 반환하는 값이 아닌 다른 값을 반환
//        return "FAILED";
//
//    }

    /**
     * 사용자 정의 어노테이션을 통해 메소드를 인터셉터
     */
//    @Around("@annotation(org.example.chap6.annotation.ToLog)")
//    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        // 인터셉트한 메소드 이름 얻기
//        String methodName = joinPoint.getSignature().getName();
//
//        // 인터셉트한 메소드의 매개변수 얻기
//        Object[] arguments = joinPoint.getArgs();
//
//        logger.info("Method " + methodName + " with parameters " + Arrays.asList(arguments) + " will execute");
//
//        // 인터셉트 메소드 반환값 얻기
//        Object returnByMethod = joinPoint.proceed();
//
//        logger.info("Method executed and returned " + returnByMethod);
//
//        return returnByMethod;
//
//    }

    /**
     * @AfterReturning : 인터셉트 메소드에서 반환된 값을 가져오기 위한 어노테이션
     * -> Object returnByMethod = joinPoint.proceed();를 수행하는 것과 동일한 역할을 수행
     * -> returning 속성에 대한 값으로 파라미터 변수명과 일치시켜야함
     */
    @AfterReturning(
            value = "@annotation(org.example.chap6.annotation.ToLog)",
            returning = "returnedValue"
    )
    public void log(Object returnedValue) throws Throwable {

        logger.info("Method executed and returned " + returnedValue);

    }



}
