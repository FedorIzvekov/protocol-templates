package com.fedorizvekov.http.servlet.server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private String email;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.firstName = name;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("email: ")
                .append(email)
                .append(", phoneNumber: ")
                .append(phoneNumber)
                .append(", password: ")
                .append(password)
                .append(", firstName: ")
                .append(firstName)
                .append(", lastName: ")
                .append(lastName)
                .toString();
    }

}
