package com.fedorizvekov.soap.jax.ws.server.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import com.fedorizvekov.soap.jax.ws.server.model.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceImplTest {

    @InjectMocks
    private RegistrationServiceImpl registrationService;


    @Test
    public void should_return_user_data() throws Exception {
        XMLStreamReader streamReader = XMLInputFactory.newFactory().createXMLStreamReader(new FileReader("client_request.xml"));

        while (streamReader.hasNext() && !(streamReader.isStartElement() && "registrationRequest".equals(streamReader.getLocalName()))) {
            streamReader.next();
        }

        Unmarshaller unmarshaller = JAXBContext.newInstance(UserDto.class).createUnmarshaller();
        UserDto userDto = unmarshaller.unmarshal(streamReader, UserDto.class).getValue();

        String result = registrationService.registration(userDto);

        assertThat(result).isEqualTo("REGISTRATION COMPLETED, user: UserDto(email=test@email.com, phoneNumber=1234567890, firstName=TestFirstName, lastName=TestLastName)");
    }

}