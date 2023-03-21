package com.photoshoot.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="clientName", length=50)
    private String clientName;

    @Column(name="email", length=500)
    private String email;

    public Client(){

    }

    public Client(Long id, String clientName, String email) {
        this.id = id;
        this.clientName = clientName;
        this.email = email;
    }

    public Client(String clientName, String email) {
        this.clientName = clientName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", email=" + email +
                '}';
    }
}
