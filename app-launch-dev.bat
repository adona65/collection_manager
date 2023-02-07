pushd %~dp0
start cmd /C "mvnw spring-boot:run"
start cmd /C "cd front && ng serve --o"