<h1 align="center">
    ToDo List
</h1>

<h4 align="center"> 
	A Java Application With Spring Boot
</h4>

<p align="center">	
  <img alt="Repository size" src="https://img.shields.io/github/repo-size/yuripalacio/first-java-api">

  <a href="https://www.linkedin.com/in/yuripalacio/">
    <img alt="Made by yuripalacio" src="https://img.shields.io/badge/made%20by-Yuri%20Palacio-%2304D361">
  </a>
  
  <a href="https://github.com/yuripalacio/first-java-apicommits/main">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/yuripalacio/first-java-api">
  </a>
  
  <a href="https://github.com/yuripalacio/first-java-api/blob/main/LICENSE">
    <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen">
  </a>
</p>

<p align="center">
  <a href="#about">About</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#technologies">Technologies</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#licence">Licence</a>
</p>

# About
This project demonstrates the creation of a simple ToDo List application using Java and Spring Boot.

The application comprises two main entities: Users and Tasks. The primary use case involves users creating and updating tasks for which they are designated as the owner.

### User
- Creation of users
- Duplication check for usernames
- Password hashing

### Task
- Task creation
- Task update for the owner
- Listing of a user's tasks

The authentication route for inserting or updating a task is implemented using the `Basic Auth` method. Prior to authenticating the user, we globally pass the user ID using the `doFilterInternal` method, enabling access to this information in other routes.

In addition, we utilized the `H2` database, which offered a practical and efficient solution during the development phase.
The inclusion of `spring-boot-devtools` enhanced our development process by enabling automatic reload, streamlining the development workflow.

# Technologies

- [Java](https://www.oracle.com/br/java/)
- [Maven](https://maven.apache.org/what-is-maven.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Initializr](https://start.spring.io/)
- [H2](https://www.h2database.com/html/main.html)
- [Project Lombok](https://projectlombok.org/)

## License

This project is under the MIT license. See the <a href="https://github.com/yuripalacio/first-java-api/blob/main/LICENSE">LICENSE</a> file for more details.

<hr />

By [Yuri Palacio](https://www.linkedin.com/in/yuri-palacio/) :wave:
