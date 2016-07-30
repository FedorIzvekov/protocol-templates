package com.fedorizvekov.http.servlet.server;

import java.io.InputStream;
import java.util.Properties;
import org.eclipse.jetty.server.Server;

public class HttpServletServer {

    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();

        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        }

        int port = Integer.parseInt(properties.getProperty("server.port"));

        Server server = new Server(port);
        server.start();
        server.join();
    }

}
