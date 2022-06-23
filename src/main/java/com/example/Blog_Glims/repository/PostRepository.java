package com.example.Blog_Glims.repository;


import com.example.Blog_Glims.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class PostRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Post> findAllPosts(){
        List<Post> posts =  jdbcTemplate.query("select * from post", new PostRowMapper());
        return posts;
    }

    // Add a new post
    public void saveNewPost(Post post){
        String mySql = "insert into post(post_nickname,post_title, post_text ) values (?,?,?)";
        int num = jdbcTemplate.update(mySql, post.getPost_nickname(),post.getPost_title(),post.getPost_text());
        System.out.println(num);
    }

    //Update a post title
    public void updatePostTitle(String post_title, int id){
        String mySql = "update post set post_title = ? where post_id = ?";
        jdbcTemplate.update(mySql, post_title, id);
    }

    //Update a post text
    public void updatePostText(String post_text, int id){
        String mySql = "update post set post_text = ? where post_id = ?";
        jdbcTemplate.update(mySql, post_text, id);
    }

    /*For deleting a post you need to delete pics
    and comments related to the post itself
    before you can do it*/
     public void deleteAPost(Post id){
         String mySql = "delete from post where post_id = ?";
         jdbcTemplate.update(mySql, id);
     }

     //Get Posts By Name
    public List<Post> getPostsByName(String post_nickname){
        String mySql = "select * from post  where post_nickname = ?";
        List <Post> p =  jdbcTemplate.query(mySql, new PostRowMapper(), post_nickname );
        return p;
    }

    //Get Posts By Date
//    public List<Post> getPostsByDate(Date date){
//        String mySql = "select post_nickname, post_title, post_text, post_date from post  where  post_date = ?";
//        List <Post> p = jdbcTemplate.query(mySql, new PostRowMapper(), date);
//        return p;
//    }


    private class PostRowMapper implements RowMapper<Post>{

        public Post mapRow(ResultSet rs, int rowNum) throws SQLException{

            Post post = new Post();
            post.setPost_id(rs.getInt("post_id"));
            post.setPost_nickname(rs.getString("post_nickname"));
            post.setPost_title(rs.getString("post_title"));
            post.setPost_text(rs.getString("post_text"));
            post.setPost_date(rs.getDate("post_date"));
            return post;
        }
    }


}
