package com.example.Blog_Glims.controller;

import com.example.Blog_Glims.model.Comment;
import com.example.Blog_Glims.model.Media;
import com.example.Blog_Glims.model.Post;
import com.example.Blog_Glims.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentsController {
    @Autowired
    CommentsService commentsService;


    //Add new comment
    @PostMapping("comments")
    public ResponseEntity<?> addNewMedia(@RequestBody Comment comment){
        commentsService.addNewComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }

    //Update a comment
    @PutMapping("/updcomm/{id}")
    public void updateComment(@PathVariable int id, @RequestBody Comment comment){
         commentsService.updateComment(comment.getComments_text(), id);
    }


    //Delete a comment
    @DeleteMapping ("/deletecom/{id}")
    public void deleteComment(@PathVariable Comment comment){
        commentsService.deleteComment(comment);
    }



}
