package com.fedorizvekov.http.spring.server.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void should_return_CREATED_and_user_data() throws Exception {

        mockMvc.perform(post("/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"test@email.com\", \"password\": \"TestPassword\", \"name\": \"TestName\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().string("REGISTRATION COMPLETED, user: UserDto(email=test@email.com, phoneNumber=null, firstName=TestName, lastName=null)"));
    }


    @Test
    public void should_return_CREATED_and_full_user_data() throws Exception {

        mockMvc.perform(post("/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"test@email.com\", \"phoneNumber\": \"1234567890\", \"password\": \"TestPassword\", \"firstName\": \"TestFirstName\", \"lastName\": \"TestLastName\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().string("REGISTRATION COMPLETED, user: UserDto(email=test@email.com, phoneNumber=1234567890, firstName=TestFirstName, lastName=TestLastName)"));
    }


    @Test
    public void should_return_CREATED_and_minimum_user_data() throws Exception {

        mockMvc.perform(post("/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"unknownParameter\": \"unknownValue\", \"email\": \"test@email.com\", \"password\": \"TestPassword\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().string("REGISTRATION COMPLETED, user: UserDto(email=test@email.com, phoneNumber=null, firstName=null, lastName=null)"));
    }


    @Test
    public void should_return_BAD_REQUEST_invalid_request_body() throws Exception {

        mockMvc.perform(post("/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("Bad request"))
                .andExpect(status().isBadRequest());
    }


    @Test
    public void should_return_BAD_REQUEST_missing_required_parameters() throws Exception {

        mockMvc.perform(post("/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"phoneNumber\": \"1234567890\", \"firstName\": \"TestFirstName\"}"))
                .andExpect(status().isBadRequest());
    }


    @Test
    public void should_return_BAD_REQUEST_password_size_is_small() throws Exception {

        mockMvc.perform(post("/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"test@email.com\", \"password\": \"1234\"}"))
                .andExpect(status().isBadRequest());
    }

}
