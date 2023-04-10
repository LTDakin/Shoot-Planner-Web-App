package com.photoshoot.demo.service;

import com.photoshoot.demo.data.PhotographerRepository;
import com.photoshoot.demo.model.Photographer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotographerService {

    private final PhotographerRepository repo;
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
            System.out.println("Error getting Photographer with id : " + id + ", Error: " + e.toString());
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
        Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder("pepper", 16, 2000, 256);
        encoder.setEncodeHashAsBase64(true);
        String encodedPass = encoder.encode(photographer.getPassword());
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
            System.out.println("Error deleting Photographer with id: "+id+" Error: " + e.toString());
        }
        return photographer;
    }

    // update a photographer
    public Photographer putPhotographer(Photographer photographer) {
        try {
            repo.save(photographer);
        }
        catch (Exception e){
            System.out.println("Error updating Photographer: " + e.toString());
        }
        return photographer;
    }

    public void loginPhotographer(Photographer photographer) {
        // username must exist in database
        Photographer dbPhotographer = repo.findByName(photographer.getName()).get(0);
        if(dbPhotographer != null){
            // hash the entered password
            Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder("pepper", 16, 2000, 256);
            encoder.setEncodeHashAsBase64(true);
            String encodedPass = encoder.encode(photographer.getPassword());
            // check hashed entered password == hashed db password
            if(dbPhotographer.getPassword() == encodedPass) {
                // TODO give a cookie
                System.out.println("have a cookie");
            }
            // TODO handle incorrect password
        }
        // TODO handle incorrect username
    }
}
