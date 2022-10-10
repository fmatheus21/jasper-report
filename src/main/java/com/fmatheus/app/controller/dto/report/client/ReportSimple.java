package com.fmatheus.app.controller.dto.report.client;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;

@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportSimple {
    private String name;
    private String document;
    private LocalDateTime createdDate;
    private String phone;
    private String email;
    private Collection<ReportDetails> addresses;
}
