package rs.raf.repositories.post;

import rs.raf.entities.Post;

import javax.security.auth.Subject;
import java.util.List;

public interface PostRepo {
    Post addPost(Post post);
    List<Post> allPosts();
    Subject findPost(Integer id);
    //void deletePost(Integer id);
}
