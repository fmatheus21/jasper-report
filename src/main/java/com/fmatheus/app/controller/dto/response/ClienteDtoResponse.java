package com.fmatheus.app.controller.dto.response;

import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDtoResponse {

    private PersonDtoResponse person;
    private ContactDtoResponse contact;
    private AddressDtoResponse address;

}
