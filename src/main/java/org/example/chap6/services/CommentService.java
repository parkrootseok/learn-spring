package org.example.chap6.services;

import java.util.logging.Logger;
import org.example.chap6.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment) {
        logger.info("publish comment: " + comment.getText());
        return "SUCCESS";
    }

}
