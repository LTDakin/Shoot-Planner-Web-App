package com.photoshoot.demo.service;

import com.photoshoot.demo.data.ClientRepository;
import com.photoshoot.demo.model.Client;
import com.photoshoot.demo.model.ShootSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repo;
    @Autowired
    public ClientService(ClientRepository repo) { this.repo = repo;}

    // get all Clients
    public List<Client> getClients() {
        List<Client> allClients = new ArrayList<>();
        for(Client client: repo.findAll()){
            allClients.add(client);
        }
        return allClients;
    }

    // get a Client by ID, returns null if it does not exist
    public Client getClientById(int id) {
        try {
            return repo.findById((long) id);
        }
        catch (Exception e){
            System.out.println("Error getting client with id : " + id + ", Error: " + e.toString());
        }
        // if entry cannot be found returns null
        return null;
    }

    // insert a client
    public Client insertClient(Client client) {
        try {
            // save to database
            repo.save(client);
        }
        catch (Exception e){
            System.out.println("Error when saving client Object to database : " + e.toString());
        }
        return client;
    }

    // delete a client
    public Client deleteClient(int id) {
        Client client = null;
        try{
            client = repo.findById((long)id);
            repo.delete(client);
        }
        catch (Exception e){
            System.out.println("Error deleting Client with id: "+id+" Error: " + e.toString());
        }
        return client;
    }

    // update a client
    public Client putClient(Client client) {
        try {
            repo.save(client);
        }
        catch (Exception e){
            System.out.println("Error updating Client: " + e.toString());
        }
        return client;
    }
}
