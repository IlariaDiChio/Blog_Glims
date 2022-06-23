package com.example.Blog_Glims.service;

import com.example.Blog_Glims.model.Media;
import com.example.Blog_Glims.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaService {

    @Autowired
    MediaRepository mediaRepository;

    //Add new media
    public void addNewMedia(Media media){
        mediaRepository.saveNewMedia(media);
    }

    //Delete a media
    public void deleteMedia(Media id){
        mediaRepository.deleteAMedia(id);
    }


}
