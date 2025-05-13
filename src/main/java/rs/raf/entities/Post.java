package rs.raf.entities;

import java.util.Date;

public class Post {
    private Integer id;
    private String title;
    private String content;
    private Date date;

    public Post(String post_title, String post_content, Date post_date) {
        this.title = post_title;
        this.content = post_content;
        this.date = post_date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
