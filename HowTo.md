# How to make this application working
## Documentation purpose
The goal of this document is explaining various informations about this project. It may contains : 
- basics informations like "how launching the application" or "how to configure it"
- explanations about some concepts for learning purposes
- indications about tricky issues and how to solve them

**What this documentation won't contains :** explanations about the code. All needed indications will be included in code itself as commentaries and docs.

## Application informations
#### Launch the application (for Windows)
- With command prompt, go to project's folder.
- Use <span style="color: green;">*mvnw spring-boot:run*</span>. This will launch the back-end Spring boot's part. It will listen by default on Spring Boot's port "8080".

#### Hot build application during developments and debugging
- Spring boot's hot build is managed by a dependency added to maven configuration (in pom.xml file) : org.springframework.boot.spring-boot-devtools

#### Conveniently launch application for developments (for Windows)
Launch <span style="color: green;">*app-launch-dev.bat*</span> script stored inside project's root directory. It will open a command prompt  executing launch of the back-end part of the application. It will contain logs from Spring.

#### Working with SQLite
SQLite was chosen because it's a lite-easy-to-use database provider. The fastest way to create an SQLite's database is to use the SQLite Studio tool.