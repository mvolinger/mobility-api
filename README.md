<h3 align="center"> 
	Mobility API
</h3>

<p align="center">
  <a href="#woman_technologist-project">Project</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#mag_right-technologies">Technologies</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#information_source-how-to-use-it">How to use it</a>&nbsp;&nbsp;&nbsp;
</p>

## :woman_technologist: Project

REST API to manage urban mobility

## :mag_right: Technologies

- Java 17
- Gradle
- Spring Boot Starter Web
- Spring Cloud OpenFeign
- Lombok
- Swagger
- Docker

## :information_source: How to use it

### Clone the project to your machine
```bash
# using this command
$ git clone https://github.com/mvolinger/mobility-api.git
```

### Running it with a Docker container
```bash
# Build the container image
$ docker build -t mobility-service .
# Run
$ docker run -dp 8080:8080 mobility-service
```

### Using it
```bash
# Swagger
http://localhost:8080/swagger-ui/
#Don't forget that final slash (seriously)

# Get information about bus lines by name
[GET] http://localhost:8080/api/bus/lines/{name}

# Get information about bus routes by id
[GET] http://localhost:8080/api/bus/routes/{id}
```

### Finally, you can always
[![Run in Postman](https://run.pstmn.io/button.svg)](https://god.postman.co/run-collection/4aa2a8a9a7089b761c91?action=collection%2Fimport)

---
Made by mvolinger :wave: [Get in touch!](https://www.linkedin.com/in/monisevolinger/)