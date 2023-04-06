package com.photoshoot.demo.controller;

import com.photoshoot.demo.model.Photographer;
import com.photoshoot.demo.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // TODO return a cookie as well
    // find a library that handles cookies Spring > React
    @PostMapping("")
    public ResponseEntity<Object> insertPhotographer(@RequestBody Photographer photographer){
        try {
            photographerService.insertPhotographer(photographer);
            return ResponseEntity.ok(photographer);
        }
        catch (Exception e){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", "Username Already Exists");
            return ResponseEntity.badRequest().body(errorMap);
        }
    }

    // TODO these need to check for cookies to make sure account owner is only one deleting, maybe take password too for extra security
    @DeleteMapping("/{id}")
    public Photographer deletePhotographer(@PathVariable int id){
        return photographerService.deletePhotographer(id);
    }

    // TODO these need to check for cookies
    @PutMapping("/{id}")
    public Photographer putPhotographer(@PathVariable int id, @RequestBody Photographer photographer){
        photographer.setId((long) id);
        return photographerService.putPhotographer(photographer);
    }
}