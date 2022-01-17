package com.example.demo.service;

import com.example.demo.exception.BalanceSheetReportException;
import com.example.demo.exception.NoReportException;
import com.example.demo.exception.ReportTypeException;
import com.example.demo.model.ReportHeader;
import com.example.demo.repository.ReportHeaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportHeaderService {

    private ReportHeaderRepository reportHeaderRepository;

    public ReportHeaderService(ReportHeaderRepository reportHeaderRepository) {
        this.reportHeaderRepository = reportHeaderRepository;
    }

    public List<ReportHeader> findAll( ReportHeader.TYPE type ){
        if ( type == null ) {
            return  reportHeaderRepository.findAll();
        }
        return reportHeaderRepository.findByType( type );
    }

    public ReportHeader saveReport( ReportHeader reportHeader ) {

        List<ReportHeader> reportHeaders = reportHeaderRepository.findByType( reportHeader.getType() );

        if ( !reportHeaders.isEmpty() ) {
            for( ReportHeader reportHeader1 : reportHeaders ) {
                if ( reportHeader1.getCreationDate().getTime() ==  reportHeader.getCreationDate().getTime() ) {
                    throw new BalanceSheetReportException();
                }
            }
        }

        return reportHeaderRepository.save(reportHeader);
    }

    public void deleteById( long id ) {
        if ( reportHeaderRepository.findById( id ).isPresent() ) {
            reportHeaderRepository.deleteById(id);
            return;
        }
        throw new NoReportException();
    }


}
