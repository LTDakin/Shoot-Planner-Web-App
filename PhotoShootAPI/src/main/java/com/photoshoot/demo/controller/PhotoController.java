package com.photoshoot.demo.controller;

import com.photoshoot.demo.model.Client;
import com.photoshoot.demo.model.Photo;
import com.photoshoot.demo.service.ClientService;
import com.photoshoot.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // TODO remove hack for allowing localhost dev
@RequestMapping(path = "/api/photo")
public class PhotoController {
    private final PhotoService photoService;

    // constructor
    @Autowired
    public PhotoController(PhotoService photoService){this.photoService = photoService;}

    @GetMapping("")
    public List<Photo> getPhotos() {
        return photoService.getPhotos();
    }

    @GetMapping("/{id}")
    public Photo getPhotoById(@PathVariable int id){
        return photoService.getPhotoById(id);
    }

    @PostMapping("")
    public Photo insertPhoto(@RequestBody Photo photo){
        return photoService.insertPhoto(photo);
    }

    @DeleteMapping("/{id}")
    public Photo deletePhoto(@PathVariable int id){
        return photoService.deletePhoto(id);
    }

    @PutMapping("/{id}")
    public Photo putPhoto(@PathVariable int id, @RequestBody Photo photo){
        photo.setId((long) id);
        return photoService.putPhoto(photo);
    }
}
