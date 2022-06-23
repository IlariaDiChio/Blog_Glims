package com.example.Blog_Glims.model;

import java.util.Date;
import java.util.List;

public class Post{
    private int post_id ;
    private String post_nickname;
    private String post_title;
    private String post_text;
    private Date post_date;

    private List<Media> medias;
    private List<Comment> comments;

    public int getPost_id() {
        return post_id;
    }

    public String getPost_nickname() {
        return post_nickname;
    }

    public String getPost_title() {
        return post_title;
    }

    public String getPost_text() {
        return post_text;
    }

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public void setPost_nickname(String post_nickname) {
        this.post_nickname = post_nickname;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public void setPost_text(String post_text) {
        this.post_text = post_text;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", post_nickname='" + post_nickname + '\'' +
                ", post_title='" + post_title + '\'' +
                ", post_text='" + post_text + '\'' +
                ", post_date=" + post_date +
                '}';
    }
}
