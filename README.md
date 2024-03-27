# Graduation project Restaurant Voting by [TopJava](https://github.com/Andrew9334/TopJava)

The project was completed in accordance with the technical specifications: REST API was designed and implemented using 
Spring-Boot/Spring Data JPA without a frontend approach.

The task is:

To build a voting system for deciding where to have lunch.

There are 2 types of users: admin and regular users.
Admin can add a restaurant and its ( != it’s) lunch menu of the day (2-5 items usually: a dish name and price)
Menu changes each day (admins do the updates).
Users can vote for the restaurant they want to have lunch at that day.
Only one vote per user.
If a user votes again the same day:
If it was before 11:00AM we assume that he changed his mind.
If it was after 11:00AM then it is too late, vote can't be changed
Each restaurant provides a new menu each day.

As a result, provide a link to github repository. It should contain the code, README.md with an API documentation and 
a couple of curl commands to test it (better - link to Swagger).
________________________________________________________________________________________________________________________
Link to Swagger: [REST API documentation](http://localhost:8080/swagger-ui/index.html)

Тестовые креденшелы:
- user@yandex.ru / password
- admin@gmail.com / admin
- guest@gmail.com / guest
________________________________________________________________________________________________________________________
### Used technologies:

* Maven 
* Spring Boot
* Spring MVC
* Spring Rest
* Spring Security
* Spring JPA
* Hibernate
* H2 database
* SLF4J
* JUnit
* Json (Jackson)
* Lombok