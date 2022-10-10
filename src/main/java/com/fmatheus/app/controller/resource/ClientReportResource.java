package com.fmatheus.app.controller.resource;

import com.fmatheus.app.controller.constant.HttpStatusConstant;
import com.fmatheus.app.controller.constant.OperationConstant;
import com.fmatheus.app.controller.constant.ResourceConstant;
import com.fmatheus.app.controller.dto.response.ClienteDtoResponse;
import com.fmatheus.app.controller.enumerable.ReportTypeEnum;
import com.fmatheus.app.controller.rule.ClienteReportRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Objects;


@RestController
@RequestMapping("/report/clients")
public class ClientReportResource {

    @Autowired
    private ClienteReportRule rule;


    @Operation(summary = OperationConstant.REPORT_SIMPLE, description = OperationConstant.REPORT_SIMPLE_DESCRIPTION,
            tags = {OperationConstant.TAG})
    @ApiResponses(value = {
            @ApiResponse(responseCode = HttpStatusConstant.OK_NUMBER, description = HttpStatusConstant.OK,
                    content = @Content(mediaType = "application/pdf")),
            @ApiResponse(responseCode = HttpStatusConstant.NO_CONTENT_NUMBER, description = HttpStatusConstant.NO_CONTENT,
                    content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping
    public void findAll(HttpServletResponse response, HttpServletRequest request, @RequestParam ReportTypeEnum type) {
        this.rule.findAll(response, type);
    }

    /*@Operation(summary = OperationConstant.GET, description = OperationConstant.CLIENT_GET_DESCRIPTION,
            tags = {OperationConstant.CLIENT_TAG})
    @ApiResponses(value = {
            @ApiResponse(responseCode = HttpStatusConstant.OK_NUMBER, description = HttpStatusConstant.OK,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteDtoResponse.class))),
            @ApiResponse(responseCode = HttpStatusConstant.BAD_REQUEST_NUMBER, description = HttpStatusConstant.BAD_REQUEST_NUMBER,
                    content = @Content(schema = @Schema(hidden = true)))
    })*/
    @GetMapping(ResourceConstant.ID)
    public ResponseEntity<ClienteDtoResponse> findAll(@PathVariable int id) {
        var result = this.rule.findById(id);
        return Objects.nonNull(result) ? ResponseEntity.ok(result) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
