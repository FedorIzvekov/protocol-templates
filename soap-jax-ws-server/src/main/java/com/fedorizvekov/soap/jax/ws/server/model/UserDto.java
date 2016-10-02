package com.fedorizvekov.soap.jax.ws.server.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"password"})
public class UserDto {

    private String email;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;

}
