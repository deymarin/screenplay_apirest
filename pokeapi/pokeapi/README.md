# POKEAPI API TESTING

Automation testing for REST API with Screenplay pattern.

## GET RESOURCES

https://pokeapi.co/api/v2/pokemon/{name}
- Validate that **ditto** 
  - Have **only** two abilities: [ limber, imposter]
  - Have the held items [ ruby, emerald, diamond ]

## POST 
JSON PLACEHOLDER API.
- Validate the successful creation of a post
  - Status 201
  - Request: title: #string, body: #string, userId: number
  - Response: id: number, title: #string, body: #string, userId: number
  - The response should contain the same data of the request

### Technologies
- Java
- Screenplay
- Cucumber
- Serenity
- Gradle

### Requirements

- Java 8
- Gradle 7.x
- IDE of preference for Java (IntelliJ IDEA, Visual Studio Code or Eclipse)

### Installation
```bash
git clone https://github.com/deymarin/screenplay_apirest.git
```

### Run tests
```bash
gradle clean test aggregate -i
```