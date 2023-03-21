package com.photoshoot.demo.service;

import com.photoshoot.demo.data.ShootSessionRepository;
import com.photoshoot.demo.model.ShootSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShootSessionService {
    // constructor
    @Autowired
    public ShootSessionService(ShootSessionRepository repo){
        this.repo = repo;
    }

    // create the repo
    private final ShootSessionRepository repo;

    // Insert method for adding new shoot sessions to database
    public ShootSession insertShootSession(ShootSession shoot){
        try {
            // save to database
            repo.save(shoot);
        }
        catch (Exception e){
            System.out.println("Error when saving Shoot Session Object to database : " + e.toString());
        }
        return shoot;

    }
    // Returns all Shoot Sessions in the database
    public List<ShootSession> getShootSessions() {
        List<ShootSession> allSessions = new ArrayList<>();
        for(ShootSession shoot: repo.findAll()){
            allSessions.add(shoot);
        }
        return allSessions;
    }

    // Returns a shoot session from id
    public ShootSession getShootSessionById(int id){
        try {
            return repo.findById((long) id);
        }
        catch (Exception e){
            System.out.println("Error getting shoot session with id : " + id + ", Error: " + e.toString());
        }
        // if entry cannot be found returns null
        return null;
    }

    // Deletes a Shoot Session from database
    public ShootSession deleteShootSession(int id){
        ShootSession shoot = null;
        try{
            shoot = repo.findById((long)id);
            repo.delete(shoot);
        }
        catch (Exception e){
            System.out.println("Error deleting ShootSession with id: "+id+" Error: " + e.toString());
        }
        return shoot;
    }

    // Updates a shoot session from /put request
    // an id is required so that save recognizes it is an already existing object
    public ShootSession putShootSession(ShootSession shoot){
        try {
            // update the entity in db
            repo.save(shoot);
        }
        catch (Exception e){
            System.out.println("Error updating ShootSession: " + e.toString());
        }
        return shoot;
    }

}
