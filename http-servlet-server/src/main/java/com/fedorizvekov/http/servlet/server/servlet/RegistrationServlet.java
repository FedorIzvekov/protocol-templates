package com.fedorizvekov.http.servlet.server.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fedorizvekov.http.servlet.server.model.UserDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        log.info("REQUEST POST endpoint {}", request.getRequestURL().toString());

        try {

            String json = request.getReader().readLine();
            UserDto userDto = new ObjectMapper().readValue(json, UserDto.class);
            log.info("Request contain user: {}", userDto.toString());

            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().write("REGISTRATION COMPLETED, user: " + userDto);

        } catch (Exception exception) {
            log.error("Something went wrong, because: ", exception);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
