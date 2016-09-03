package com.fedorizvekov.soap.jax.ws.server.service;

import javax.jws.WebService;
import com.fedorizvekov.soap.jax.ws.server.model.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebService(endpointInterface = "com.fedorizvekov.soap.jax.ws.server.service.RegistrationService")
public class RegistrationServiceImpl implements RegistrationService {

    Logger log = LoggerFactory.getLogger(RegistrationServiceImpl.class);

    @Override
    public String registration(UserDto userDto) {

        log.info("REQUEST POST, endpoint /registration was called");

        return "REGISTRATION COMPLETED SUCCESSFULLY, user: " + userDto;
    }
}
