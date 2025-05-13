package rs.raf.repositories.comment;

import rs.raf.entities.Comment;

import java.util.List;

public interface CommentRepo {
    void addComment(Comment comment);
    List<Comment> listComments();

}
