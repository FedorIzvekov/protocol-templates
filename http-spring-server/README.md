# Http-spring-server
This project is an HTTP server implemented using the Spring framework.

## Building, Running and Checking

1. Navigate to the project directory:
```
cd <projects_directory>/http-spring-server
```

2. Build the project:
```
mvn clean install
```

3. Run the server:
```
java -jar ./target/http-spring-server-1.0.0-SNAPSHOT.jar
```
4. Check the server:
```
curl -v -i -X POST -H 'Content-Type: application/json' -d '{"email": "test@email.com", "password": "TestPassword", "name": "TestName"}' http://localhost:8083/registration
```
```
curl -v -i -X POST -H 'Content-Type: application/json' -d '{"email": "test@email.com", "phoneNumber": "1234567890", "password": "TestPassword", "firstName": "TestFirstName", "lastName": "TestLastName"}' http://localhost:8083/registration
```