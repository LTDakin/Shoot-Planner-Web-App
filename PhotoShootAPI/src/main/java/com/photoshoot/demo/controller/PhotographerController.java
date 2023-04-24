package com.photoshoot.demo.controller;

import com.photoshoot.demo.model.Photographer;
import com.photoshoot.demo.service.PhotographerService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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

    // API Request for Login
    @PostMapping("/login")
    public ResponseEntity<Object> loginPhotographer(@RequestBody Photographer photographer, HttpServletResponse response){
        try{
            // try logging in with credentials if it works then create a Response
            Cookie cookie = photographerService.loginPhotographer(photographer.getName(), photographer.getPassword());
            response.addCookie(cookie);
            return ResponseEntity.ok(photographer);
        }
        catch(Exception e){
            System.out.println("Returning error response because of " + e.toString());
            return null;
        }
    }

    // API Request for Account Creation
    // TODO bug where account is created but error sent back, or frontend doesn't properly close the account creation modal and displays error message
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

    // TODO these need to check for cookies
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