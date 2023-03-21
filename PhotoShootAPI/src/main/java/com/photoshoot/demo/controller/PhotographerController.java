package com.photoshoot.demo.controller;

import com.photoshoot.demo.model.Photographer;
import com.photoshoot.demo.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // TODO remove hack for allowing localhost dev
@RequestMapping(path = "/api/photographer")
public class PhotographerController {
    private final PhotographerService photographerService;

    // constructor
    @Autowired
    public PhotographerController(PhotographerService photographerService){this.photographerService = photographerService;}

    @GetMapping("")
    public List<Photographer> getPhotographers() {
        return photographerService.getPhotographers();
    }

    @GetMapping("/{id}")
    public Photographer getPhotographerById(@PathVariable int id){
        return photographerService.getPhotographerById(id);
    }

    @PostMapping("")
    public Photographer insertPhotographer(@RequestBody Photographer photographer){
        return photographerService.insertPhotographer(photographer);
    }

    @DeleteMapping("/{id}")
    public Photographer deletePhotographer(@PathVariable int id){
        return photographerService.deletePhotographer(id);
    }

    @PutMapping("/{id}")
    public Photographer putPhotographer(@PathVariable int id, @RequestBody Photographer photographer){
        photographer.setId((long) id);
        return photographerService.putPhotographer(photographer);
    }
}