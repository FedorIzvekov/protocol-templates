package com.fedorizvekov.soap.jax.ws.server.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import com.fedorizvekov.soap.jax.ws.server.model.UserDto;

@WebService
public interface RegistrationService {

    @WebMethod
    String registration(@WebParam(name = "registrationRequest", targetNamespace = "http://model.server.ws.jax.soap.fedorizvekov.com/") UserDto userDto);

}
