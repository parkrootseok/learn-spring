package org.example.chap6;

import java.util.logging.Logger;
import org.example.chap6.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var service = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("demo comment");
        comment.setAuthor("seorin");

        String value = service.publishComment(comment);

        logger.info(value);

    }

}
