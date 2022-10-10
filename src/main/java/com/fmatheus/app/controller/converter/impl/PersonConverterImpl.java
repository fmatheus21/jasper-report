package com.fmatheus.app.controller.converter.impl;

import com.fmatheus.app.controller.converter.PersonConverter;
import com.fmatheus.app.controller.dto.response.PersonDtoResponse;
import com.fmatheus.app.controller.util.AppUtil;
import com.fmatheus.app.model.entity.Person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonConverterImpl implements PersonConverter {

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PersonDtoResponse converterToResponse(Person person) {
        person.setName(AppUtil.convertFirstUppercaseCharacter(person.getName()));
        person.setDocument(AppUtil.removeSpecialCharacters(person.getDocument()));
        var converter = this.modelMapper.map(person, PersonDtoResponse.class);
        converter.setType(person.getPersonType().getName());
        return converter;
    }

}
