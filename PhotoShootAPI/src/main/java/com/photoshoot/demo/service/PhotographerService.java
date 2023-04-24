package com.photoshoot.demo.service;

import com.photoshoot.demo.data.PhotographerRepository;
import com.photoshoot.demo.model.Photographer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import jakarta.servlet.http.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotographerService {

    private final PhotographerRepository repo;
    @Autowired
    private Pbkdf2PasswordEncoder passwordEncoder;
    @Autowired
    public PhotographerService(PhotographerRepository repo) { this.repo = repo;}

    // get all Photographers
    public List<Photographer> getPhotographers() {
        List<Photographer> allPhotographers = new ArrayList<>();
        for(Photographer photographer: repo.findAll()){
            allPhotographers.add(photographer);
        }
        return allPhotographers;
    }

    // get a Photographer by ID, returns null if it does not exist
    public Photographer getPhotographerById(int id) {
        try {
            return repo.findById((long) id);
        }
        catch (Exception e){
            System.out.println("Error getting Photographer with id : " + id + ", Error: " + e);
        }
        // if entry cannot be found returns null
        return null;
    }

    // insert a Photographer
    public void insertPhotographer(Photographer photographer) throws Exception {
        // check if username or email is taken
        if(!repo.findByName(photographer.getName()).isEmpty()){
            throw new Exception("Username already exists in database");
        }
        // encode the password
        String encodedPass = passwordEncoder.encode(photographer.getPassword());
        // create new photographer object with the encoded password and save to database
        Photographer newPhotographer = new Photographer(photographer.getName(), photographer.getCamera(), photographer.getEmail(), encodedPass );
        repo.save(newPhotographer);
    }

    // delete a Photographer
    public Photographer deletePhotographer(int id) {
        Photographer photographer = null;
        try{
            photographer = repo.findById((long)id);
            repo.delete(photographer);
        }
        catch (Exception e){
            System.out.println("Error deleting Photographer with id: "+id+" Error: " + e);
        }
        return photographer;
    }

    // update a photographer
    public Photographer putPhotographer(Photographer photographer) {
        try {
            repo.save(photographer);
        }
        catch (Exception e){
            System.out.println("Error updating Photographer: " + e);
        }
        return photographer;
    }

    public Cookie loginPhotographer(String name, String password) throws Exception {
        // username must exist in database
        Photographer dbPhotographer = repo.findByName(name).get(0);
        if(dbPhotographer != null){
            // check entered password == db password, matches will automatically hash the stored password
            if(passwordEncoder.matches(password, dbPhotographer.getPassword())) {
                Cookie cookie = new Cookie("username", dbPhotographer.getName());
                cookie.setMaxAge(60*60*24);
                cookie.setPath("/");
                return cookie;
            }
            else {
                // handle incorrect password
                System.out.println("password was incorrect");
                throw new Exception("incorrect password");
            }
        }
        else{
            // handle incorrect username
            System.out.println("Username was incorrect");
            throw new Exception("incorrect username");
        }
    }
}
