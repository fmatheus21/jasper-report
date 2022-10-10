package com.fmatheus.app.controller.dto.report.client;

import lombok.*;

@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportDetails {
    private String place;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String zipCode;
}
