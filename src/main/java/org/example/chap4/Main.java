package org.example.chap4;

import org.example.chap4.proxies.EmailCommentNotificationProxy;
import org.example.chap4.repositories.Comment;
import org.example.chap4.repositories.DBCommentRepository;
import org.example.chap4.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var comment = new Comment();
        comment.setAuthor("Root");
        comment.setText("Hello!");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);

    }

}
