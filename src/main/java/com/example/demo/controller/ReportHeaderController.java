package com.example.demo.controller;

import com.example.demo.dto.AddReportDto;
import com.example.demo.mapper.ReportMapper;
import com.example.demo.model.ReportHeader;
import com.example.demo.service.ReportHeaderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Validated
@RestController
@RequestMapping("/report")
public class ReportHeaderController {

    private ReportHeaderService reportHeaderService;
    private ReportMapper reportMapper;

    public ReportHeaderController(ReportHeaderService reportHeaderService, ReportMapper reportMapper) {
        this.reportHeaderService = reportHeaderService;
        this.reportMapper = reportMapper;
    }

    @PostMapping
    public ResponseEntity<ReportHeader> postReport(
            @Valid
            @RequestBody AddReportDto dto
    ) {
        return  ResponseEntity.ok().body(reportHeaderService.saveReport( reportMapper.getReportFromAddReportDto( dto ) ) );
    }


    @GetMapping
    public List<ReportHeader> getReports(
            @RequestParam( required = false ) ReportHeader.TYPE type
    ) {
        return reportHeaderService.findAll( type );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(
            @PathVariable long id
    ){
        reportHeaderService.deleteById( id );

        return ResponseEntity.ok().build();
    }

}
