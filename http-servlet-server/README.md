# Http-servlet-server
This project is an HTTP server implemented as a servlet, offering functionality for HTTP communication.

## Building, Running and Checking

1. Navigate to the project directory:
```
cd <projects_directory>/http-servlet-server
```

2. Build the project:
```
mvn clean install
```

3. Run the server:
```
java -jar <projects_directory>/http-servlet-server/target/http-servlet-server-1.0.0-SNAPSHOT-jar-with-dependencies.jar
```

4. Check the server:
```
curl -v -i -X POST -H 'Content-Type: application/json' -d '{"email": "emailValue", "phoneNumber": "phoneNumberValue", "password": "passwordValue", "firstName": "firstNameValue", "lastName": "lastNameValue"}' http://localhost:8080/registration
```