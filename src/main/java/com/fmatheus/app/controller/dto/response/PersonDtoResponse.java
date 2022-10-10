package com.fmatheus.app.controller.dto.response;

import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDtoResponse {

    private String name;
    private String document;
    private String type;

}
