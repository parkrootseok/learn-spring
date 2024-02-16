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

        service.publishComment(comment);

        // 해당 메소드만 인터셉터하여 Aspect Logic 수행 후 메소드 호출
        service.deleteComment(comment);

        service.editComment(comment);

    }

}
