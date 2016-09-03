package com.fedorizvekov.soap.jax.ws.server.model;

public class UserDto {

    private String email;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
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
