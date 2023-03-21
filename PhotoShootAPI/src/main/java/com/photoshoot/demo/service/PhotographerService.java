package com.photoshoot.demo.service;

import com.photoshoot.demo.data.PhotographerRepository;
import com.photoshoot.demo.model.Photographer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            // save to database
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

    // update a client
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
