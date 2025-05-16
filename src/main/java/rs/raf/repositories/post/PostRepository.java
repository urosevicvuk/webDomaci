package rs.raf.repositories.post;

import rs.raf.entities.Post;

import java.util.List;

public interface PostRepository {

    Post addPost(Post post);
    List<Post> getAllPosts();
    Post findPost(Integer id);
    void deletePost(Integer id);

}
