package org.example.chap4.repositories;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class DBCommentRepository implements CommentRepository  {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing Comment:" + comment.getText());
    }

}
