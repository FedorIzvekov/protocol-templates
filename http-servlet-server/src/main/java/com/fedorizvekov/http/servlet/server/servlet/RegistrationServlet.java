package com.fedorizvekov.http.servlet.server.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fedorizvekov.http.servlet.server.model.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    Logger log = LoggerFactory.getLogger(RegistrationServlet.class);


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("REQUEST POST, endpoint /registration was called");

        try {

            String json = request.getReader().readLine();
            UserDto userDto = new ObjectMapper().readValue(json, UserDto.class);
            log.info("Request contain user: " + userDto.toString());

            response.setStatus(HttpServletResponse.SC_CREATED);

        } catch (Exception exception) {
            log.error("Something went wrong, because: ", exception);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
