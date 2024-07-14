## Overview
Project is a CRUD (create, read, update, delete) web application. The data are Dwarves - "class" that can have multiple "elements" - Weapons.

Backend is written in Java with Spring Boot, as a set of microservices communicating through REST API. Maven helps with managing dependencies and Docker makes it easily reusable in different environemnts. I use JPA to interact with H2 Databse.

Frontend is written in TypeScripts with Angular framework. It allows for more user-friendly accessing and modyfing the data. 

## How to run
Requires running Docker. From main folder:

`.\build.sh`

`docker-compose up`

Open http://localhost:8087/