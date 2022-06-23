package com.example.Blog_Glims.repository;

import com.example.Blog_Glims.model.Comment;
import com.example.Blog_Glims.model.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CommentsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Comment> getCommentsByPostId(int relatedcomment_post_id){
        String mySql = "select * from comments where relatedcomment_post_id = ?";
        List<Comment> p = jdbcTemplate.query(mySql, new CommentRowMapper(),relatedcomment_post_id);
        return p;
    }

    //Add a new comment
    public void saveNewComment(Comment comment){
        String mySql = "insert into comments(comments_nickname, comments_text) values (?'?)";
        int num = jdbcTemplate.update(mySql, comment.getComments_nickname(), comment.getComments_text());
        System.out.println(num);
    }

    //Update a comment text
    public void updateCommentText(String comments_text, int id){
        String mySql = "update post set comments_text = ? where comments_id = ?";
        jdbcTemplate.update(mySql, comments_text, id);
    }

    //Delete a comment
    public void deleteAComment(Comment id){
        String mySql = "delete from comments where comments_id = ?";
        jdbcTemplate.update(mySql, id);
    }


    private class CommentRowMapper implements RowMapper<Comment> {
        public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
            Comment comment = new Comment();
            comment.setComments_id(rs.getInt("comments_id"));
            comment.setComments_nickname(rs.getString("comments_nickname"));
            comment.setComments_text(rs.getString("comments_text"));
            comment.setComments_date(rs.getDate("comments_date"));
            comment.setRelated_post_id(rs.getInt("relatedcomment_post_id"));
            return comment;
        }
    }
}