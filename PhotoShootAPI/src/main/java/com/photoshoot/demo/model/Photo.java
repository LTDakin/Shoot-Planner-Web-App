package com.photoshoot.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "photoName", length = 50)
    private String photoName;
    @Column(name = "shootSessionID")
    private int shootSessionKey;

    public Photo() {
    }

    public Photo(Long id, String photoName, int shootSessionKey) {
        this.id = id;
        this.photoName = photoName;
        this.shootSessionKey = shootSessionKey;
    }

    public Photo(String photoName, int shootSessionKey) {
        this.photoName = photoName;
        this.shootSessionKey = shootSessionKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public int getShootSessionKey() {
        return shootSessionKey;
    }

    public void setShootSessionKey(int shootSessionKey) {
        this.shootSessionKey = shootSessionKey;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", photoName='" + photoName + '\'' +
                ", shootSessionKey=" + shootSessionKey +
                '}';
    }
}
