package com.example.Blog_Glims.model;

import java.sql.Blob;

public class Media {

    private int media_id;
    private Blob media_type;
    private int related_post_id;

    public int getMedia_id() {
        return media_id;
    }

    public Blob getMedia_type() {
        return media_type;
    }

    public int getRelated_post_id() {
        return related_post_id;
    }

    public void setMedia_id(int media_id) {
        this.media_id = media_id;
    }

    public void setMedia_type(Blob media_type) {
        this.media_type = media_type;
    }

    public void setRelated_post_id(int related_post_id) {
        this.related_post_id = related_post_id;
    }

    @Override
    public String toString() {
        return "Media{" +
                "media_id=" + media_id +
                ", media_type=" + media_type +
                ", related_post_id=" + related_post_id +
                '}';
    }
}
