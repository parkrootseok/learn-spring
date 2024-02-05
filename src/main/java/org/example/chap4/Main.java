package org.example.chap4;

import org.example.chap4.proxies.EmailCommentNotificationProxy;
import org.example.chap4.repositories.Comment;
import org.example.chap4.repositories.DBCommentRepository;
import org.example.chap4.services.CommentService;

public class Main {

    public static void main(String[] args) {

        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();

        var commentService = new CommentService(
                commentRepository,
                commentNotificationProxy
        );

        var comment = new Comment();
        comment.setAuthor("Root");
        comment.setText("Hello!");

        commentService.publishComment(comment);

    }

}
