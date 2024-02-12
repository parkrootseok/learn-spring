package org.example.chap4;

import org.example.chap4.proxies.CommentNotificationProxy;
import org.example.chap4.repositories.CommentRepository;
import org.example.chap4.services.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
        basePackages = {"org.example.chap4.proxies", "org.example.chap4.repositories", "org.example.chap4.services"}
)
public class ProjectConfiguration {

//    @Bean
//    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
//    public CommentService commentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
//        return new CommentService(commentRepository, commentNotificationProxy);
//    }

}
