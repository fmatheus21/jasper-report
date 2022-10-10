package com.fmatheus.app.controller.rule;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApplicationRule {

    @Value("${report.jasper}")
    private String pathReport;

    @Value("${report.logo}")
    private String pathReportLogo;

    @Value("${report.logo-coffee}")
    private String pathReportLogoCoffee;

    @Value("${report.client-simple}")
    private String pathReportClientSimple;

    @Value("${report.client-details}")
    private String pathReportClientDetails;



}
