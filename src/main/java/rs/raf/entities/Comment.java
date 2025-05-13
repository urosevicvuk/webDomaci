package rs.raf.entities;

public class Comment {
    private Integer id;
    private String content;
    private Integer userId;
    private Integer postId;

    public Comment(String comment_text, Integer comment_userId, Integer comment_postId) {
        this.content = comment_text;
        this.userId = comment_userId;
        this.postId = comment_postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

}
