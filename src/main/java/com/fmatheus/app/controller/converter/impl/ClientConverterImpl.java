package com.fmatheus.app.controller.converter.impl;

import com.fmatheus.app.controller.converter.AddressConverter;
import com.fmatheus.app.controller.converter.ClientConverter;
import com.fmatheus.app.controller.converter.ContactConverter;
import com.fmatheus.app.controller.converter.PersonConverter;
import com.fmatheus.app.controller.dto.response.ClienteDtoResponse;
import com.fmatheus.app.model.entity.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientConverterImpl implements ClientConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PersonConverter personConverter;

    @Autowired
    private ContactConverter contactConverter;

    @Autowired
    private AddressConverter addressConverter;

    @Override
    public ClienteDtoResponse converterToResponse(Client client) {
        var personDtoResponse = this.personConverter.converterToResponse(client.getIdPerson());
        var contactDtoResponse = this.contactConverter.converterToResponse(client.getIdPerson().getContact());
        var addresDtoResponse = this.addressConverter.converterToResponse(client.getIdPerson().getAddress());
        return ClienteDtoResponse.builder()
                .person(personDtoResponse)
                .contact(contactDtoResponse)
                .address(addresDtoResponse)
                .build();
    }
}
