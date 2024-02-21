package org.example.chap6;

import org.example.chap6.aspects.LoggingAspect;
import org.example.chap6.aspects.SecurityAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Aspect를 활성화하기 위해 @EnableAspectAutoProxy 어노테이션 추가
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan(
        basePackages = {"org.example.chap6.services"}
)
public class ProjectConfiguration {

    /**
     * Context에 Aspect Class Bean 등록
     * @return
     */
    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

    @Bean
    SecurityAspect securityAspect() {
        return new SecurityAspect();
    }

}
