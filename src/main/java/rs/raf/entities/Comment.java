package rs.raf.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Comment {

    @NotNull(message = "This field is required")
    @NotEmpty(message = "This field is required")
    private String author;

    @NotNull(message = "This field is required")
    @NotEmpty(message = "This field is required")
    private String text;

    private Integer blogPostId;

    public Comment() {
    }

    public Comment(String author, String text, Integer blogPostId) {
        this.author = author;
        this.text = text;
        this.blogPostId = blogPostId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getBlogPostId() {
        return blogPostId;
    }

    public void setBlogPostId(Integer blogPostId) {
        this.blogPostId = blogPostId;
    }
}