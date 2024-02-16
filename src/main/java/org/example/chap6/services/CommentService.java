package org.example.chap6.services;

import java.util.Arrays;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.example.chap6.Comment;
import org.example.chap6.annotation.ToLog;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment comment) {
        logger.info("publish comment: " + comment.getText());
    }

    /**
     * 인터셉터 할 메소드에 사용자 정의 어노테이션(@ToLog)을 명시
     */
    @ToLog
    public void deleteComment(Comment comment) {
        logger.info("delete comment: " + comment.getText());
    }

    public void editComment(Comment comment) {
        logger.info("edit comment: " + comment.getText());
    }

}