package rs.raf.entities;

import java.sql.Date;

public class Post {
    private Integer post_id;
    private String post_title;
    private String post_content;
    private Date post_date;

    public Post() {
    }

    public Post(Integer post_id, String post_title, String post_content, Date post_date) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.post_content = post_content;
        this.post_date = post_date;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }
}
