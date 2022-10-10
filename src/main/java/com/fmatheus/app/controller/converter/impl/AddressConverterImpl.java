package com.fmatheus.app.controller.converter.impl;

import com.fmatheus.app.controller.converter.AddressConverter;
import com.fmatheus.app.controller.dto.response.AddressDtoResponse;
import com.fmatheus.app.model.entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.fmatheus.app.controller.util.AppUtil.convertAllUppercaseCharacters;
import static com.fmatheus.app.controller.util.AppUtil.convertFirstUppercaseCharacter;

@Component
public class AddressConverterImpl implements AddressConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AddressDtoResponse converterToResponse(Address address) {
        address.setState(convertAllUppercaseCharacters(address.getState()));
        address.setDistrict(convertFirstUppercaseCharacter(address.getDistrict()));
        address.setPlace(convertFirstUppercaseCharacter(address.getPlace()));
        address.setCity(convertFirstUppercaseCharacter(address.getCity()));
        address.setComplement(Objects.nonNull(address.getComplement()) ? convertFirstUppercaseCharacter(address.getComplement()) : null);
        return this.modelMapper.map(address, AddressDtoResponse.class);
    }

}
