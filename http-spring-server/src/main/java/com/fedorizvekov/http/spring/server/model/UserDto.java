package com.fedorizvekov.http.spring.server.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"password"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    @NotNull
    private String email;
    @NotNull
    @Size(min = 8)
    private String password;
    private String phoneNumber;
    @JsonAlias({"name", "firstName"})
    private String firstName;
    private String lastName;

}
