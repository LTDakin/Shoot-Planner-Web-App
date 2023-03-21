package com.photoshoot.demo.controller;

import com.photoshoot.demo.model.ShootSession;
import com.photoshoot.demo.service.ShootSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // TODO remove hack for allowing localhost dev
@RequestMapping(path = "/api/shootsession")
public class ShootSessionController {

    private final ShootSessionService shootService;

    // constructor
    @Autowired
    public ShootSessionController(ShootSessionService shootService) {
        this.shootService = shootService;
    }

    @GetMapping("")
    public List<ShootSession> getShootSessions() {
        return shootService.getShootSessions();
    }

    @GetMapping("/{id}")
    public ShootSession getShootSessionById(@PathVariable int id){
        return shootService.getShootSessionById(id);
    }

    @PostMapping("")
    public ShootSession insertShootSession(@RequestBody ShootSession shootSession){
        return shootService.insertShootSession(shootSession);
    }

    @DeleteMapping("/{id}")
    public ShootSession deleteShootSession(@PathVariable int id){
        return shootService.deleteShootSession(id);
    }

    @PutMapping("/{id}")
    public ShootSession putShootSession(@PathVariable int id ,@RequestBody ShootSession shootSession){
        shootSession.setId((long) id);
        return shootService.putShootSession(shootSession);
    }
}
