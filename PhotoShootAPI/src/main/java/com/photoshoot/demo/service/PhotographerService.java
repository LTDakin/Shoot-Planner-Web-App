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
    public Photographer insertPhotographer(Photographer photographer) {
        try {
            // TODO check if username is taken
            if(!repo.findByName(photographer.getName()).isEmpty()){
                throw new Exception("Username already exists in database");
            }

            // TODO encode the password
            Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder("pepper", 16, 2000, 256);
            encoder.setEncodeHashAsBase64(true);
            // this is a bit of a hack, essentially frontend is storing the user's entered pass into the hash field to be used here
            // reason doing so, don't have to create entire new object format to pass information and can reuse photographer
            String encodedPass = encoder.encode(photographer.getHash());

            // TODO create new photographer object and save to database
            repo.save(photographer);
        }
        catch (Exception e){
            System.out.println("Error when saving Photographer Object to database : " + e.toString());
        }
        return photographer;
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
}
