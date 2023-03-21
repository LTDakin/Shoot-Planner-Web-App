package com.photoshoot.demo.model;

import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "ShootSession")
public class ShootSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "clientID", length=50)
    private Long clientId;
    @Column(name = "photographerID", length=50)
    private Long photographerId;
    @Column(name = "sessionDate")
    private Date sessionDate;
    @Column(name ="location", length=100)
    private String location;
    @Column(name="hourLength")
    private Integer hourLength;

    // empty constructor
    public ShootSession(){

    }

    // all data fields constructor
    public ShootSession(Long id, Long clientId, Long photographerId, Date sessionDate, String location, Integer hourLength, String email) {
        this.id = id;
        this.clientId = clientId;
        this.photographerId = photographerId;
        this.sessionDate = sessionDate;
        this.location = location;
        this.hourLength = hourLength;
    }

    // no id constructor
    public ShootSession(Long clientId, Long photographerId, Date sessionDate, String location, Integer hourLength, String email) {
        this.clientId = clientId;
        this.photographerId = photographerId;
        this.sessionDate = sessionDate;
        this.location = location;
        this.hourLength = hourLength;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getHourLength() {
        return hourLength;
    }

    public void setHourLength(Integer hourLength) {
        this.hourLength = hourLength;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getPhotographerId() {
        return photographerId;
    }

    public void setPhotographerId(Long photographerId) {
        this.photographerId = photographerId;
    }

    @Override
    public String toString() {
        return "ShootSession{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", photographerId=" + photographerId +
                ", sessionDate=" + sessionDate +
                ", location='" + location + '\'' +
                ", hourLength=" + hourLength +
                '}';
    }
}
