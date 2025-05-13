package rs.raf.entities;

public class Comment {
    private Integer comment_id;
    private String comment_text;
    private Integer comment_userId;
    private Integer comment_postId;

    public Comment(String comment_text, Integer comment_userId, Integer comment_postId) {
        this.comment_text = comment_text;
        this.comment_userId = comment_userId;
        this.comment_postId = comment_postId;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Integer getComment_userId() {
        return comment_userId;
    }

    public void setComment_userId(Integer comment_userId) {
        this.comment_userId = comment_userId;
    }

    public Integer getComment_postId() {
        return comment_postId;
    }

    public void setComment_postId(Integer comment_postId) {
        this.comment_postId = comment_postId;
    }

}
