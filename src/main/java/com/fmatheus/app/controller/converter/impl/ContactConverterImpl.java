package com.fmatheus.app.controller.converter.impl;

import com.fmatheus.app.controller.converter.ContactConverter;
import com.fmatheus.app.controller.dto.response.ContactDtoResponse;
import com.fmatheus.app.controller.util.AppUtil;
import com.fmatheus.app.model.entity.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactConverterImpl implements ContactConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContactDtoResponse converterToResponse(Contact contact) {
        contact.setEmail(AppUtil.convertAllLowercaseCharacters(contact.getEmail()));
        contact.setPhone(AppUtil.removeSpecialCharacters(contact.getPhone()));
        return this.modelMapper.map(contact, ContactDtoResponse.class);
    }
}
