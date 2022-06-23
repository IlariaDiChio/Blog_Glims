package com.example.Blog_Glims.model;

import java.util.Date;

public class Comment {
    private int comments_id;
    private String comments_nickname;
    private String comments_text;
    private Date comments_date;
    private int relatedcomment_post_id;

    public int getComments_id() {
        return comments_id;
    }

    public String getComments_nickname() {
        return comments_nickname;
    }

    public String getComments_text() {
        return comments_text;
    }

    public Date getComments_date() {
        return comments_date;
    }

    public int getRelated_post_id() {
        return relatedcomment_post_id;
    }

    public void setComments_id(int comments_id) {
        this.comments_id = comments_id;
    }

    public void setComments_nickname(String comments_nickname) {
        this.comments_nickname = comments_nickname;
    }

    public void setComments_text(String comments_text) {
        this.comments_text = comments_text;
    }

    public void setComments_date(Date comments_date) {
        this.comments_date = comments_date;
    }

    public void setRelated_post_id(int relatedcomment_post_id) {
        this.relatedcomment_post_id = relatedcomment_post_id;
    }
}
