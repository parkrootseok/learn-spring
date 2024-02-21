package org.example.chap4;

import org.example.chap4.proxies.EmailCommentNotificationProxy;
import org.example.chap4.repositories.Comment;
import org.example.chap4.repositories.DBCommentRepository;
import org.example.chap4.services.CommentService;
import org.example.chap4.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    static boolean isEqual;

    public static void main(String[] args) {

//        System.out.println("ready to create Context");
//        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
//        System.out.println("Complete to create Context");

//        var commentService1 = context.getBean(CommentService.class);
//        var commentService2 = context.getBean(CommentService.class);경
//
//        isEqual = commentService1 == commentService2;
//        System.out.println(isEqual);
//

//        System.out.println("ready to create Context");
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
//        System.out.println("Complete to create Context");

        /**
         * @Lazy를 추가한 CommentService는 Bean을 가져올 때 생성하지만
         * UserService는 컨텍스트를 생성할 때 Bean을 생성함
         */
//        var commentService = context.getBean(CommentService.class);
//        var userService = context.getBean(UserService.class);
//
//        isEqual = commentService.getCommentRepository() == userService.getCommentRepository();
//        System.out.println(isEqual);

        /**
         * 프로토타입을 가지는 Bean을 참조하면, 두 인스턴스는 다름
         * -> 프로로타입을 가지는 Bean은 참조할 때 마다 Spring에서 인스턴스를 생성
         */

//        var cs1 = context.getBean("commentService", CommentService.class);
//        var cs2 = context.getBean("commentService", CommentService.class);

//        isEqual = cs1 == cs2;
//        System.out.println(isEqual);

//        var s1 = context.getBean(CommentService.class);
//        var s2 = context.getBean(UserService.class);
//
//        isEqual = s1.getCommentRepository() == s2.getCommentRepository();
//        System.out.println(isEqual);


    }

}
