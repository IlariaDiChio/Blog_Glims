package com.example.Blog_Glims.controller;

import com.example.Blog_Glims.model.Comment;
import com.example.Blog_Glims.model.Media;
import com.example.Blog_Glims.model.Post;
import com.example.Blog_Glims.service.CommentsService;
import com.example.Blog_Glims.service.MediaService;
import com.example.Blog_Glims.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    MediaService mediaService;
    @Autowired
    CommentsService commentsService;

    //Get all the posts
    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    //Add a new post
    @PostMapping("post")
    public ResponseEntity<?> createPost(@RequestBody Post post){
        postService.createPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    //Get Posts + comments + media by Name
    @GetMapping("/posts/getposts/{name}")
    public List<Post> getPostCommentsMediaByName(@PathVariable String name){
        return postService.getPostCommentsMediaByName(name);
    }

    //Get Posts + comments + media by Date
//    @GetMapping("/posts/getpdate/{date}")
//    public List<Post>getPostCommentsMediaByDate(@PathVariable Date date){
//        return postService.getPostCommentsMediaByDate(date);
//    }

    //Update Post's title
    @PutMapping("/updtitle/{id}")
    public void updateTitle(@PathVariable int id, @RequestBody Post post){
        postService.updatePostTitle(post.getPost_title(), id);
    }

    //Update Post's text
    @PutMapping("/updtext/{id}")
    public void updateText(@PathVariable int id, @RequestBody Post post){
        postService.updatePostText(post.getPost_text(), id);
    }



    //Delete a post (with all its comments and medias)
    @DeleteMapping("/postdelete/{id}")
    public void cancelPost(@PathVariable Post post){
        postService.deletePost(post);
    }


}
