package org.example.chap4.proxies;

import org.example.chap4.repositories.Comment;

public interface CommentNotificationProxy {

    void sendComment(Comment comment);

}
