# Collection manager
The goal of this project is to practice various concepts and technologies during a real development process : the creation of an application for managing collections easily (coins, stamps, discs, whatsoever).

## Technologies and concepts used :

#### Front-End
1. Angular

#### Back-end
1. Spring boot
2. Spring security

#### About security of the application
Note that for the moment, the application won't be well secured. For example communication with Spring's services will be performed with HTTP protocol using Basic Auth, or no strong password will be asked to users.

Concerning database, SQLite will be used as it is an easy-to-use database provider, but without a system of credentials to access it, the data won't be protected. Using another more production-base database would be easy by changing configuration of the application. 

In a first step, the goal will be to get a working application in order to practice things like Spring Boot, Sprint Security or Angular. Unlike in a real production use case scenario, properly securing the application will be done later.