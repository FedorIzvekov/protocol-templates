package com.fedorizvekov.soap.jax.ws.server.service;

import javax.jws.WebService;
import com.fedorizvekov.soap.jax.ws.server.model.UserDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebService(endpointInterface = "com.fedorizvekov.soap.jax.ws.server.service.RegistrationService")
public class RegistrationServiceImpl implements RegistrationService {

    @Override
    public String registration(UserDto userDto) {

        log.info("REQUEST POST, endpoint /registration was called");
        return "REGISTRATION COMPLETED, user: " + userDto;
    }
}
