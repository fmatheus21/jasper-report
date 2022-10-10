package com.fmatheus.app.controller.rule;

import com.fmatheus.app.controller.constant.FormatConstant;
import com.fmatheus.app.controller.dto.report.client.ReportDetails;
import com.fmatheus.app.controller.dto.report.client.ReportSimple;
import com.fmatheus.app.controller.dto.response.ClienteDtoResponse;
import com.fmatheus.app.controller.enumerable.ReportTypeEnum;
import com.fmatheus.app.controller.util.AppUtil;
import com.fmatheus.app.model.service.ClientService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

@Component
public class ClienteReportRule {

    @Autowired
    private MessageResponseRule messageResponseRule;

    @Autowired
    private ClientService clientServicevice;

    @Autowired
    private ReportRule reportRule;

    public void findAll(HttpServletResponse response, ReportTypeEnum type) {
        this.printOut(response, type);
    }

    public ClienteDtoResponse findById(int id) {
        return this.clientServicevice.findById(id).orElseThrow(this.messageResponseRule::errorNotFound);
    }


    public void printOut(HttpServletResponse response, ReportTypeEnum type) {
        try {
            this.reportRule.createPdf(response, this.converterReportList(), type);
        } catch (JRException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    private Collection<ReportSimple> converterReportList() {
        var clients = this.clientServicevice.findAll();
        return clients.stream().map(this::converterReport).toList();
    }

    private ReportSimple converterReport(ClienteDtoResponse dto) {
        return ReportSimple.builder()
                .name(dto.getPerson().getName())
                .document(dto.getPerson().getType().equalsIgnoreCase("PESSOA FISICA") ? AppUtil.formatCPF(dto.getPerson().getDocument()) : AppUtil.formatCNPJ(dto.getPerson().getDocument()))
                .phone(AppUtil.countCharacter(dto.getContact().getPhone()) == 11 ? AppUtil.formatMask(dto.getContact().getPhone(), FormatConstant.PHONE) : AppUtil.formatMask(dto.getContact().getPhone(), FormatConstant.PHONE_OLD))
                .email(dto.getContact().getEmail())
                .addresses(Collections.singleton(
                        ReportDetails.builder()
                                .place(dto.getAddress().getPlace())
                                .number(dto.getAddress().getNumber())
                                .complement(dto.getAddress().getComplement())
                                .district(dto.getAddress().getDistrict())
                                .city(dto.getAddress().getCity())
                                .state(dto.getAddress().getState())
                                .zipCode(AppUtil.formatMask(dto.getAddress().getZipCode(), FormatConstant.ZIP_CODE))
                                .build()
                ))
                .build();
    }

}
