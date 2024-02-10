package org.example.chap4;

import org.example.chap4.proxies.EmailCommentNotificationProxy;
import org.example.chap4.repositories.Comment;
import org.example.chap4.repositories.DBCommentRepository;
import org.example.chap4.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

//        System.out.println("ready to create Context");
//        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
//        System.out.println("Complete to create Context");

//        var commentService1 = context.getBean(CommentService.class);
//        var commentService2 = context.getBean(CommentService.class);경
//
//        boolean isEqual = commentService1 == commentService2;
//        System.out.println(isEqual);
//

        System.out.println("ready to create Context");
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        System.out.println("Complete to create Context");

        /**
         * @Lazy를 추가한 CommentService는 Bean을 가져올 때 생성하지만
         * UserService는 컨텍스트를 생성할 때 Bean을 생성함
         */
        var commentService = context.getBean(CommentService.class);
        var userService = context.getBean(CommentService.class);

        boolean isEqual = commentService.getCommentRepository() == userService.getCommentRepository();
        System.out.println(isEqual);

    }

}
