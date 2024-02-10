package org.example.chap4;

import org.example.chap4.proxies.EmailCommentNotificationProxy;
import org.example.chap4.repositories.Comment;
import org.example.chap4.repositories.DBCommentRepository;
import org.example.chap4.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var commentService1 = context.getBean(CommentService.class);
        var commentService2 = context.getBean(CommentService.class);

        boolean isEqual = commentService1 == commentService2;
        System.out.println(isEqual);

        var commentService = context.getBean(CommentService.class);
        var userService = context.getBean(CommentService.class);

        isEqual = commentService.getCommentRepository() == userService.getCommentRepository();
        System.out.println(isEqual);

    }

}
