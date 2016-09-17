**# Websocket-servlet-server
This project implements a WebSocket server using a servlet, offering functionality for WebSocket communication.

## Building, Running and Checking

1. Navigate to the project directory:
```
cd <projects_directory>/websocket-servlet-server
```

2. Build the project:
```
mvn clean install
```

3. Run the server:
```
java -jar ./target/websocket-servlet-server-1.0.0-SNAPSHOT.jar
```

4. Check the server:
    * Use the UI of the [websocket-client](../websocket-client/README.md#websocket-client) project.
    * Connect to ws://localhost:8082/messenger. 
    * Interact with the WebSocket server through the client interface.