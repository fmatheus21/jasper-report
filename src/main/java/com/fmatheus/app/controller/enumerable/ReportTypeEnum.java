package com.fmatheus.app.controller.enumerable;

import lombok.Getter;

public enum ReportTypeEnum {

    CLIENT_SIMPLE("Client", "Clientes Simplificado", "report", null),
    CLIENT_DETAILS("Client Details", "Clientes Detalhado", "report", "subreport");


    @Getter
    private final String type;

    @Getter
    private final String title;

    @Getter
    private final String reportName;

    @Getter
    private final String subreportName;



    ReportTypeEnum(String type, String title, String reportName, String subreportName) {
        this.type = type;
        this.title = title;
        this.reportName = reportName;
        this.subreportName = subreportName;
    }

}
