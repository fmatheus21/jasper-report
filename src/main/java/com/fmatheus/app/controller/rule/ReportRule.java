package com.fmatheus.app.controller.rule;

import com.fmatheus.app.controller.dto.report.client.ReportSimple;
import com.fmatheus.app.controller.dto.report.client.Title;
import com.fmatheus.app.controller.enumerable.ReportTypeEnum;
import com.fmatheus.app.controller.util.AppUtil;
import lombok.SneakyThrows;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

@Component
public class ReportRule {

    private static final String JRXML = ".jrxml";
    private static final String JASPER = ".jasper";
    private String pathReport;
    private String pathSubReport;
    private String pathTitle;
    private String pathLogo;
    private String pathLogoCoffee;


    @Autowired
    private ApplicationRule application;

    private void initPath(ReportTypeEnum type) {
        String dir = System.getProperty("user.dir");
        pathReport = dir.concat(Objects.requireNonNull(this.path(type)));
        pathSubReport = dir.concat(Objects.requireNonNull(this.path(type)));
        pathTitle = dir.concat(this.application.getPathReport());
        pathLogo = dir.concat(this.application.getPathReportLogo());
        pathLogoCoffee = dir.concat(this.application.getPathReportLogoCoffee());
        this.jasperCompile(type);
    }

    /**
     * Retorna o caminhos do relatorio.
     *
     * @param type Tipo de relatorio
     * @return String
     * @author Fernando Matheus
     */
    private String path(ReportTypeEnum type) {
        switch (type) {
            case CLIENT_SIMPLE:
                return this.application.getPathReportClientSimple();
            case CLIENT_DETAILS:
                return this.application.getPathReportClientDetails();
            default:
        }

        return null;
    }

    public void createPdf(HttpServletResponse response, Collection<ReportSimple> reports, ReportTypeEnum type) throws JRException, IOException {
        this.initPath(type);
        JRDataSource datasource = new JRBeanCollectionDataSource(reports);
        this.jasperPrint(type, response, datasource);
    }

    @SneakyThrows
    private void jasperPrint(ReportTypeEnum type, HttpServletResponse response, JRDataSource datasource) {

        var reportJasper = pathReport.concat("/") + type.getReportName().concat(JASPER);

        Map<String, Object> reportParam = this.parametersReport(type);
        Thread.currentThread().getContextClassLoader();


        JasperPrint printOut = JasperFillManager.fillReport(reportJasper, reportParam, datasource);
        byte[] bytes = JasperExportManager.exportReportToPdf(printOut);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline");
        response.setContentLength(bytes.length);

        OutputStream output = response.getOutputStream();
        output.write(bytes, 0, bytes.length);
        output.flush();
        output.close();

    }

    /**
     * Compila o arquivo jrxml convertendo para jasper.
     *
     * @param type Tipo de relatorio
     * @author Fernando Matheus
     */
    private void jasperCompile(ReportTypeEnum type) {

        var titleJrxml = pathTitle.concat("/title").concat(JRXML);
        var titleJasper = pathTitle.concat("/title").concat(JASPER);

        var reportJrxml = pathReport.concat("/") + type.getReportName().concat(JRXML);
        var reportJasper = pathReport.concat("/") + type.getReportName().concat(JASPER);

        try {
            JasperCompileManager.compileReportToFile(titleJrxml, titleJasper);
            JasperCompileManager.compileReportToFile(reportJrxml, reportJasper);
        } catch (JRException e) {
            e.printStackTrace();
        }

        if (type.getType().equalsIgnoreCase(ReportTypeEnum.CLIENT_DETAILS.getType())) {
            var subreportJrxml = pathSubReport.concat("/") + type.getSubreportName().concat(JRXML);
            var subreportJasper = pathSubReport.concat("/") + type.getSubreportName().concat(JASPER);
            try {
                JasperCompileManager.compileReportToFile(subreportJrxml, subreportJasper);
            } catch (JRException e) {
                e.printStackTrace();
            }
        }


    }

    @SneakyThrows
    private Map<String, Object> parametersReport(ReportTypeEnum type) {

        var title = Title.builder()
                .title(type.getTitle())
                .logo(this.logo(pathLogo))
                .logoCoffee(this.logo(pathLogoCoffee))
                .build();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("pathReport", pathReport);
        parameters.put("pathTitle", pathTitle.concat("/title").concat(JASPER));
        parameters.put("listTitle", Collections.singletonList(title));
        return parameters;
    }

    @SneakyThrows
    private String logo(String logo) {
        File file = ResourceUtils.getFile(logo);
        return AppUtil.converterImagetoBase64(file);
    }

}
