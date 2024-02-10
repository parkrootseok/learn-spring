package org.example.chap4.services;

import org.example.chap4.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final CommentRepository commentRepository ;

    public UserService(CommentRepository commentRepository) {
        System.out.println("UserService 생성!");
        this.commentRepository = commentRepository;
    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }

}
