package com.example.Blog_Glims.service;


import com.example.Blog_Glims.model.Comment;
import com.example.Blog_Glims.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

    @Autowired
    CommentsRepository commentsRepository;

    //Add new comment
    public void addNewComment(Comment comment){
        commentsRepository.saveNewComment(comment);
    }

    //Update a post comment
    public void updateComment(String comments_text, int id){
        commentsRepository.updateCommentText(comments_text, id);
    }

    //Delete a comment
    public void deleteComment(Comment id){
        commentsRepository.deleteAComment(id);
    }


}
