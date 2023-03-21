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

    public Photographer() {
    }

    public Photographer(Long id, String name, String camera, String email) {
        this.id = id;
        this.name = name;
        this.camera = camera;
        this.email = email;
    }

    public Photographer(String name, String camera, String email) {
        this.name = name;
        this.camera = camera;
        this.email = email;
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
