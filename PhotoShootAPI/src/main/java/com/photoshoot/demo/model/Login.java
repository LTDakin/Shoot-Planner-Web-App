package com.photoshoot.demo.model;

public class Login {
    private String username;
    private String password;

    public Login() {

    }

    public Login(String user, String pass){
        this.username = user;
        this.password = pass;
    }

    public String getPassword() { return password; }

    public void setPassword(String pass) { this.password = pass;}

    public String getUsername() { return username; }
}
