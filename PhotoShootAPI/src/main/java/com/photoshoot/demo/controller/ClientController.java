package com.photoshoot.demo.controller;

import com.photoshoot.demo.model.Client;
import com.photoshoot.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // TODO remove hack for allowing localhost dev
@RequestMapping(path = "/api/client")
public class ClientController {
    private final ClientService clientService;

    // constructor
    @Autowired
    public ClientController(ClientService clientService){this.clientService = clientService;}

    @GetMapping("")
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable int id){
        return clientService.getClientById(id);
    }

    @PostMapping("")
    public Client insertClient(@RequestBody Client client){
        return clientService.insertClient(client);
    }

    @DeleteMapping("/{id}")
    public Client deleteClient(@PathVariable int id){
        return clientService.deleteClient(id);
    }

    @PutMapping("/{id}")
    public Client putClient(@PathVariable int id, @RequestBody Client client){
        client.setId((long) id);
        return clientService.putClient(client);
    }
}
