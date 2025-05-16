package rs.raf.services;

import rs.raf.entities.Post;
import rs.raf.repositories.post.PostRepository;

import javax.inject.Inject;
import java.util.List;

public class PostService {

    @Inject
    private PostRepository postRepository;

    public Post addPost(Post post) {
        return this.postRepository.addPost(post);
    }

    public List<Post> getAllPosts() {
        return this.postRepository.getAllPosts();
    }

    public Post findPost(int id) {
        return this.postRepository.findPost(id);
    }

    public void deletePost(int id) {
        this.postRepository.deletePost(id);
    }

}
