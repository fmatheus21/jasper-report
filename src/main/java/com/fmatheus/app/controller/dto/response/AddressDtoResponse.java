package com.fmatheus.app.controller.dto.response;

import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDtoResponse {

    private String place;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String zipCode;

}
