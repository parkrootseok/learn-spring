package org.example.chap4.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class DBCommentRepository implements CommentRepository  {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing Comment:" + comment.getText());
    }

}
