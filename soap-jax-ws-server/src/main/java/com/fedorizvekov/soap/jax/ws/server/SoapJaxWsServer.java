package com.fedorizvekov.soap.jax.ws.server;

import java.io.InputStream;
import java.util.Properties;
import javax.xml.ws.Endpoint;
import com.fedorizvekov.soap.jax.ws.server.service.RegistrationServiceImpl;

public class SoapJaxWsServer {

    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();

        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        }

        String port = properties.getProperty("server.port");

        String address = "http://localhost:" + port + "/registration";
        Endpoint.publish(address, new RegistrationServiceImpl());

    }
}
