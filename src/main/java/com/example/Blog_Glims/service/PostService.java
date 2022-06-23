package com.example.Blog_Glims.service;

import com.example.Blog_Glims.model.Comment;
import com.example.Blog_Glims.model.Media;
import com.example.Blog_Glims.model.Post;
import com.example.Blog_Glims.repository.CommentsRepository;
import com.example.Blog_Glims.repository.MediaRepository;
import com.example.Blog_Glims.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    MediaRepository mediaRepository;

    @Autowired
    CommentsRepository commentsRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAllPosts();
    }

    //Add new post
    public void createPost(Post post){
        postRepository.saveNewPost(post);
    }

    //Get Posts By Name
    public List<Post> getPostsByName(String post_nickname){
        return postRepository.getPostsByName(post_nickname);
    }

    //Get Posts By Date
//    public List<Post> getPostsByDate (Date date){
//        return postRepository.getPostsByDate(date);
//    }

    //Update a post title
    public void updatePostTitle(String post_title, int id){
        postRepository.updatePostTitle(post_title, id);
    }

    //Update a post text
    public void updatePostText(String post_text, int id){
        postRepository.updatePostText(post_text, id);
    }

    //Get Posts + comments + media by Name
    public List<Post> getPostCommentsMediaByName(String nickname){
        System.out.println(nickname);
        List<Post> listPost = postRepository.getPostsByName(nickname);
        for (Post post : listPost){
            System.out.println(post);
            List <Media> m = mediaRepository.getMediaByPostId(post.getPost_id());
            post.setMedias(m);
            List <Comment> c = commentsRepository.getCommentsByPostId(post.getPost_id());
            post.setComments(c);
        }
        return listPost;
    }

    //Get Posts + comments + media by Date
//    public List<Post> getPostCommentsMediaByDate(Date date){
//        System.out.println(date);
//        List<Post> listPost = postRepository.getPostsByDate(date);
//        for (Post post : listPost){
//            System.out.println(post);
//            List <Media> m = mediaRepository.getMediaByPostId(post.getPost_id());
//            post.setMedias(m);
//            List <Comment> c = commentsRepository.getCommentsByPostId(post.getPost_id());
//            post.setComments(c);
//        }
//        return listPost;
//    }

//    Delete a post
    public void deletePost(Post id){
        postRepository.deleteAPost(id);
    }




}
