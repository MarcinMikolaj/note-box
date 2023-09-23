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
Application to manage and store your notes.

## Technologies
* Java 17
* Spring Boot (Web, JPA, Validation)
* Postgres
* Lombok
* Swagger
* JUnit5
* Mockito

## About the project


## Functional and non-functional requirements

### The non-functional requirements that have been set for the application include:
- Project should be based on Java 17

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

1. Open this URL https://github.com/MarcinMikolaj/note-box
2. Now we must find the green rectangle where it writes „<>CODE”
3. We select HTTPS and there is a link below that you need to copy
4. The next step is to open IntelliJ And choose File > New > Project from Version Control
5. Then we need to paste our URL from Github, select the path to our project on our PC, and click Clone.
6. Enjoy our Project! 😄

## Resources

📦 Postamn Collection to test API V1: [note-box-collection.postman_collection.zip](https://github.com/MarcinMikolaj/note-box/files/12707339/note-box-collection.postman_collection.zip) \

🧪 Swagger: http://localhost:9000/swagger-ui/index.html

## Contact

Author: Marcin Mikołajczyk \
Email: marcin.mikolajczyk22@gmail.com \
Project Link: https://github.com/MarcinMikolaj/note-box
