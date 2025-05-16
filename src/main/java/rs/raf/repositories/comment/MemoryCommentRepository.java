package rs.raf.repositories.comment;

import rs.raf.entities.Comment;
import rs.raf.repositories.post.PostRepository;
import rs.raf.repositories.post.MemoryPostRepository;

import javax.inject.Inject;
import java.util.List;

public class MemoryCommentRepository implements CommentRepository {

    @Inject
    private PostRepository postRepository;

    @Override
    public synchronized Comment addComment(Comment comment,Integer blogPostId) {
        ((MemoryPostRepository) postRepository).addCommentToPost(blogPostId, comment);
        return comment;
    }

    @Override
    public List<Comment> getAllComments(Integer blogPostId) {

        return postRepository.findPost(blogPostId).getComments();

    }
}