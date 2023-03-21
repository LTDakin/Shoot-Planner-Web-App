package com.photoshoot.demo.service;

import com.photoshoot.demo.data.PhotoRepository;
import com.photoshoot.demo.model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoService {

    private final PhotoRepository repo;
    @Autowired
    public PhotoService(PhotoRepository repo) { this.repo = repo;}

    // get all Photos
    public List<Photo> getPhotos() {
        List<Photo> allPhotos = new ArrayList<>();
        for(Photo Photo: repo.findAll()){
            allPhotos.add(Photo);
        }
        return allPhotos;
    }

    // get a Photo by ID, returns null if it does not exist
    public Photo getPhotoById(int id) {
        try {
            return repo.findById((long) id);
        }
        catch (Exception e){
            System.out.println("Error getting Photo with id : " + id + ", Error: " + e.toString());
        }
        // if entry cannot be found returns null
        return null;
    }

    // insert a Photo
    public Photo insertPhoto(Photo photo) {
        try {
            // save to database
            repo.save(photo);
        }
        catch (Exception e){
            System.out.println("Error when saving Photo Object to database : " + e.toString());
        }
        return photo;
    }

    // delete a Photo
    public Photo deletePhoto(int id) {
        Photo photo = null;
        try{
            photo = repo.findById((long)id);
            repo.delete(photo);
        }
        catch (Exception e){
            System.out.println("Error deleting Photo with id: "+id+" Error: " + e.toString());
        }
        return photo;
    }

    // update a Photo
    public Photo putPhoto(Photo photo) {
        try {
            repo.save(photo);
        }
        catch (Exception e){
            System.out.println("Error updating Photo: " + e.toString());
        }
        return photo;
    }
}

