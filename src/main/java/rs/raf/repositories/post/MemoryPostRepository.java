package rs.raf.repositories.post;

import rs.raf.entities.Post;
import rs.raf.entities.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MemoryPostRepository implements PostRepository {

    private static final List<Post> posts = new CopyOnWriteArrayList<>();

    @Override
    public synchronized Post addPost(Post post) {
        Integer id = posts.size();
        post.setId(id);
        post.setComments(new CopyOnWriteArrayList<>());
        posts.add(Math.toIntExact(id), post);

        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        return new ArrayList<>(posts);
    }

    @Override
    public Post findPost(Integer id) {
        return posts.get(id);
    }

    @Override
    public void deletePost(Integer id) {
        posts.remove(id);
    }

    public void addCommentToPost(Integer postId, Comment comment) {
        posts.get(postId).getComments().add(comment);
    }
}
