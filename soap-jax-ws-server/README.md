# Soap-jax-ws-server
This project implements a SOAP web service using JAX-WS, providing server-side functionality for handling registration-related SOAP requests.

## Building, Running and Checking

1. Navigate to the project directory:
```
cd <projects_directory>/soap-jax-ws-server
```

2. Build the project:
```
mvn clean install
```

3. Run the server:
```
java -jar ./target/soap-jax-ws-server-1.0.0-SNAPSHOT.jar
```

4. Check the WSDL:
```
curl "http://localhost:8081/registration?wsdl"
```

5. Check the server:
```
curl -H "Content-Type: text/xml;charset=UTF-8" -d @client_request.xml http://localhost:8081/registration
```

## WSDL Generation

```
wsgen -cp target/classes -wsdl -r ./wsdl -verbose com.fedorizvekov.soap.jax.ws.server.service.RegistrationServiceImpl
```

## Generation Client & Server from WSDL

```
mkdir -p ./generated/ && wsimport -s ./generated/ -keep -p com.fedorizvekov.soap.jax.ws.generated ./wsdl/RegistrationServiceImplService.wsdl
```