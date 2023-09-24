# note-box

## Table of contents
- [General info](#general-info)
- [Technologies](#technologies)
- [About the project](#about-the-project)
  
- [Functional and non-functional requirements](#functional-and-non-functional-requirements)
- [Project status](#project-status)
- [Resources](#resources)
- [Contact](#contact)

## General info
Simple CRUD application to manage and store your notes.

## Technologies
* Java 17
* Spring Boot (Web, JPA, Validation)
* Postgres
* Lombok
* Swagger
* MapStruct
* JUnit5
* Mockito

## About the project


## Functional and non-functional requirements

### The non-functional requirements that have been set for the application include:


### The functional requirements that have been set for the application include:

- Application should be based on Java 17
- User should be able to add new note which will be stored and managed.
- The note should have a follow structure and meet the conditions presented
```
{
“title”:String[A-Za-z],
“content”:String[A-Za-z0-9\s]
“date”:LocalDateTime - data ostatniej modyfikacji
}
```
- User should receive information if provided invalid Note DTO (example: content shouldn't contain special characters)
- User could get all stored notes
- User could get all stored notes by title pattern (any string of characters that is included in title)
- The user should be able to update a saved note by sending the content of the new note request and an ID indicating note to update.
- User should be able to remove stored note by note id.

## Project status

The project has been completed, all functional and non-functional requirements have been implemented.

## Setup

### Project dowload
1. Open this URL https://github.com/MarcinMikolaj/note-box
2. Now we must find the green rectangle where it writes „<>CODE”
3. We select HTTPS and there is a link below that you need to copy
4. The next step is to open IntelliJ And choose File > New > Project from Version Control
5. Then we need to paste our URL from Github, select the path to our project on our PC, and click Clone.
6. Enjoy our Project! 😄

### Run with Docker

To run the project with a docker profile, the application file should be built with the `maven clean install` command. Once the artifact is prepared and located under `/target` directory, then the `docker-compose up --build` could be executed. The app should be available under the URL configured in the docker-compose file (port 9000 same as for dev profile).

### Run localy
If you want to run the app locally then it's required to have PostreSQL database installed.
PostgreSQL installation (should be not modified, meaning the default config should be selected):

1. Download the installation package from Installation package - please choose according to the operation system.
2. Go through the installation steps.
3. Please remember that the password provided on the 'Password' screen would be used in the application properties. If u'll choose admin123 then there'll be NO need to change dev app config. REMEMBER THE PROVIDED PASSWORD if u would decide to choose different one!
4. Now when your database is reade you can user PgAdmin or for example DBeaver to create Database where we will storage our tables.

## Resources

📦 Postamn Collection to test API V1: [note-box-collection.postman_collection.zip](https://github.com/MarcinMikolaj/note-box/files/12707339/note-box-collection.postman_collection.zip) \

🧪 Swagger: http://localhost:9000/swagger-ui/index.html

## Contact

Author: Marcin Mikołajczyk \
Email: marcin.mikolajczyk22@gmail.com \
Project Link: https://github.com/MarcinMikolaj/note-box
