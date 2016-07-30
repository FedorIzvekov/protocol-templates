# Http-servlet-server

## Building, run and check

1. Navigate to the project directory:
```
cd <projects_directory>/http-servlet-server
```

2. Build:
```
mvn clean install
```

3. Run:
```
java -jar <projects_directory>/http-servlet-server/target/http-servlet-server-1.0.0-SNAPSHOT-jar-with-dependencies.jar
```

4. Check:
```
curl -v -i -X POST -H 'Content-Type: application/json' -d '{"email": "emailValue", "phoneNumber": "phoneNumberValue", "password": "passwordValue", "firstName": "firstNameValue", "lastName": "lastNameValue"}' http://localhost:8080/registration
```