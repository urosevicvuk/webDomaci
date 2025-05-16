package rs.raf.services;

import rs.raf.entities.Comment;
import rs.raf.repositories.comment.CommentRepository;

import javax.inject.Inject;
import java.util.List;

public class CommentService {

    @Inject
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment,Integer postId) {
        this.commentRepository.addComment(comment,postId);
        return comment;
    }

    public List<Comment> getComments(Integer postID) {
        return this.commentRepository.getAllComments(postID);
    }

}
