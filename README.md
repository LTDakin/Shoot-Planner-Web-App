# Shoot-Planner-Web-App

This is a side project of mine to practice creating Full Stack Java Spring Web applications.

Tech Stack: 
  - Databse : SQL
  - API: Java Spring Boot
  - Frontend: React
 
 The purpose of this site is to allow photographers to plan photography sessions, organize them, and view past sessions. Currently the database looks like the following:\
 
                                       photographer -> ShootSession <- client
                                                            ^
                                                         photos
 
 Shoot Session contains foreign keys to photographers, clients, and photos. When a new shoot sessions is created the site will check which photographer is logged in, check
 what client the shoot is for, and once created allow photos to be added to the shoot session so that when it is selected the photographer can upload and view all photos
 related to the session. 
 
 Current edge cases not handled: 
  - duplicate clients is a problem since names are checked to see which client is being referenced. So if there are two clients with the same name this is an issue
  - security is weak since shoot sessions can be added to different photographers by sending a wrong photographer id to the backend, this can be fixed with a two step
    check perhaps to make sure the id being sent is the one that is logged in? 
