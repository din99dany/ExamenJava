package com.example.demo.mapper;

import com.example.demo.dto.AddReportDto;
import com.example.demo.model.ReportHeader;
import org.springframework.stereotype.Component;

@Component
public class ReportMapper {

    public ReportHeader getReportFromAddReportDto(AddReportDto dto){
        return new ReportHeader( dto.getType(),  dto.getCreationDate(), dto.getCreationUser(), dto.getTitle() );
    }

}
