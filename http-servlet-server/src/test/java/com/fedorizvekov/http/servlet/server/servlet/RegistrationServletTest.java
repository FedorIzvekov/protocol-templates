package com.fedorizvekov.http.servlet.server.servlet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServletTest {

    @Mock
    private HttpServletRequest servletRequest;
    @Mock
    private HttpServletResponse servletResponse;

    @InjectMocks
    private RegistrationServlet registrationServlet;

    private StringWriter stringWriter;


    @Before
    public void setUp() {
        when(servletRequest.getRequestURL()).thenReturn(new StringBuffer("http://localhost:8080/registration"));
    }


    @Test
    public void should_doPost_return_SC_CREATED_and_user_data() throws Exception {
        when(servletRequest.getReader()).thenReturn(new BufferedReader(new StringReader("{\"email\": \"test@email.com\", \"password\": \"TestPassword\", \"name\": \"TestName\"}")));
        stringWriter = new StringWriter();
        when(servletResponse.getWriter()).thenReturn(new PrintWriter(stringWriter));

        registrationServlet.doPost(servletRequest, servletResponse);

        verify(servletResponse).setStatus(HttpServletResponse.SC_CREATED);
        assertThat(stringWriter.toString()).isEqualTo("REGISTRATION COMPLETED, user: UserDto(email=test@email.com, phoneNumber=null, firstName=TestName, lastName=null)");
    }


    @Test
    public void should_doPost_return_SC_CREATED_and_full_user_data() throws Exception {
        when(servletRequest.getReader()).thenReturn(new BufferedReader(new StringReader("{\"email\": \"test@email.com\", \"phoneNumber\": \"1234567890\", \"password\": \"TestPassword\", \"firstName\": \"TestFirstName\", \"lastName\": \"TestLastName\"}")));
        stringWriter = new StringWriter();
        when(servletResponse.getWriter()).thenReturn(new PrintWriter(stringWriter));

        registrationServlet.doPost(servletRequest, servletResponse);

        verify(servletResponse).setStatus(HttpServletResponse.SC_CREATED);
        assertThat(stringWriter.toString()).isEqualTo("REGISTRATION COMPLETED, user: UserDto(email=test@email.com, phoneNumber=1234567890, firstName=TestFirstName, lastName=TestLastName)");
    }


    @Test
    public void should_doPost_return_SC_CREATED_and_empty_user_data() throws Exception {
        when(servletRequest.getReader()).thenReturn(new BufferedReader(new StringReader("{\"unknownParameter\": \"unknownValue\"}")));
        stringWriter = new StringWriter();
        when(servletResponse.getWriter()).thenReturn(new PrintWriter(stringWriter));

        registrationServlet.doPost(servletRequest, servletResponse);

        verify(servletResponse).setStatus(HttpServletResponse.SC_CREATED);
        assertThat(stringWriter.toString()).isEqualTo("REGISTRATION COMPLETED, user: UserDto(email=null, phoneNumber=null, firstName=null, lastName=null)");
    }


    @Test
    public void should_doPost_return_SC_BAD_REQUEST() throws Exception {
        when(servletRequest.getReader()).thenReturn(new BufferedReader(new StringReader("Bad request")));

        registrationServlet.doPost(servletRequest, servletResponse);

        verify(servletResponse).setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }


    @Test
    public void should_doPost_return_SC_INTERNAL_SERVER_ERROR() throws Exception {
        when(servletRequest.getReader()).thenThrow(new IOException("Something went wrong"));

        registrationServlet.doPost(servletRequest, servletResponse);

        verify(servletResponse).setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

}
