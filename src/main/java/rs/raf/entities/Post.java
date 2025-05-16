package rs.raf.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {

    private Integer id;
    private List<Comment> comments;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDateTime date;

    @NotNull(message = "This field is required")
    @NotEmpty(message = "This field is required")
    private String author;

    @NotNull(message = "This field is required")
    @NotEmpty(message = "This field is required")
    private String title;

    @NotNull(message = "This field is required")
    @NotEmpty(message = "This field is required")
    private String content;

    public Post() {
        this.date = LocalDateTime.now();
        this.comments = new ArrayList<>();
    }

    public Post(String author, String title, String content) {
        this();
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public Post(Integer id, LocalDateTime date, String author, String title, String content) {
        this.id = id;
        this.date = date;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
