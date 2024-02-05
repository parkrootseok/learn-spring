package org.example.chap4.repositories;

public class DBCommentRepository implements CommentRepository  {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing Comment:" + comment.getText());
    }

}
