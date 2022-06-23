package com.example.Blog_Glims.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.Blog_Glims.model.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MediaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Media> getMediaByPostId(int related_post_id){
        String mySql = "select * from media where related_post_id = ?";
        List<Media> p = jdbcTemplate.query(mySql, new MediaRowMapper(),related_post_id);
        return p;
    }

    //Add a new media
    public void saveNewMedia(Media media){
        String mySql = "insert into media(media_type) values (?)";
        int num = jdbcTemplate.update(mySql, media.getMedia_type());
        System.out.println(num);
    }


    //Delete a media
    public void deleteAMedia(Media id){
        String mySql = "delete from media where media_id = ?";
        jdbcTemplate.update(mySql, id);
    }



    private class MediaRowMapper implements RowMapper<Media>{

        public Media mapRow(ResultSet rs, int rowNum) throws SQLException {

            Media media = new Media();
            media.setMedia_id(rs.getInt("media_id"));
            media.setMedia_type(rs.getBlob("media_type"));
            media.setRelated_post_id(rs.getInt("related_post_id"));

            return media;
        }
    }



}
