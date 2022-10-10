package com.fmatheus.app.controller.dto.response;

import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDtoResponse {

    private String phone;
    private String email;

}
