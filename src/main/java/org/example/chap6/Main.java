package org.example.chap6;

import org.example.chap6.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var service = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("demo comment");
        comment.setAuthor("seorin");

        service.publishComment(comment);

    }

}
