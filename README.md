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
 
 Project Milestones: 
 DONE: 
  - Account Creation and Login functionality
  - Shoot planning creation functionality
  - landing page, planner page
 
 UNDONE:
  - Store photos in shoot sessions
  - explore into a specific shoot session
  - account page
  - site style modernization
  - 
