package com.photoshoot.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Photographer")
public class Photographer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "camera", length = 100)
    private String camera;
    @Column(name = "email", length = 500)
    private String email;
    @Column(name = "hash", length = 500)
    private String hash;
    @Column(name = "salt", length = 500)
    private String salt;

    public Photographer() {
    }

    public Photographer(Long id, String name, String camera, String email, String hash) {
        this.id = id;
        this.name = name;
        this.camera = camera;
        this.email = email;
        this.hash = hash;
    }

    public Photographer(String name, String camera, String email, String password) {
        this.name = name;
        this.camera = camera;
        this.email = email;
        this.hash = hash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHash(String password) { this.hash = hash; }

    public String getHash() { return hash; }

    public void setSalt(String salt) { this.salt = salt; }

    public String getSalt() { return salt;}

    @Override
    public String toString() {
        return "Photographer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", camera='" + camera + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
