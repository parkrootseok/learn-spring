package org.example.chap4;

import org.example.chap4.proxies.CommentNotificationProxy;
import org.example.chap4.repositories.CommentRepository;
import org.example.chap4.services.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ComponentScan(
        basePackages = {"org.example.chap4.proxies", "org.example.chap4.repositories", "org.example.chap4.services"}
)
@Configuration
public class ProjectConfiguration {

    @Bean
    public CommentService commentService(
            CommentRepository commentRepository,
            @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy
    ) {
        return new CommentService(commentRepository, commentNotificationProxy);
    }

}
