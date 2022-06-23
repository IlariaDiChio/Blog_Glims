package com.example.Blog_Glims.controller;

import com.example.Blog_Glims.model.Media;
import com.example.Blog_Glims.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MediaController {

    @Autowired
    MediaService mediaService;

    //Add new media
    @PostMapping("media")
    public ResponseEntity<?> addNewMedia(@RequestBody Media media){
        mediaService.addNewMedia(media);
        return ResponseEntity.status(HttpStatus.CREATED).body(media);
    }

    //Delete a media
    @DeleteMapping("/deletemed/{id}")
    public void deleteMedia(@PathVariable int id, @RequestBody Media media){
        mediaService.deleteMedia(media);
    }


}
