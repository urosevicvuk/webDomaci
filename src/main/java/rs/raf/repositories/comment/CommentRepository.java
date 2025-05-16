package rs.raf.repositories.comment;

import rs.raf.entities.Comment;

import java.util.List;

public interface CommentRepository {
    Comment addComment(Comment comment,Integer blogPostId);
    List<Comment> getAllComments(Integer blogPostId);
}
