package com.example.demo.service;

import com.example.demo.exception.BalanceSheetReportException;
import com.example.demo.exception.NoReportException;
import com.example.demo.model.ReportHeader;
import com.example.demo.repository.ReportHeaderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportHeaderServiceTest {

    @Mock
    private ReportHeaderRepository reportHeaderRepository;

    @InjectMocks
    private ReportHeaderService reportHeaderService;

    @Test
    void testDeleteById() {

        when( reportHeaderRepository.findById( any() ) ).thenReturn( Optional.of( new ReportHeader() ) );
        assertDoesNotThrow( () -> reportHeaderRepository.deleteById(10L) );

        when( reportHeaderRepository.findById( any() ) ).thenReturn( Optional.empty() );
        assertThrows(NoReportException.class, ()-> reportHeaderService.deleteById(1));
    }

    @Test
    void testsaveReport() {
        ReportHeader reportHeader = new ReportHeader( 1, ReportHeader.TYPE.CASH_FLOW,
                new Date(),1, "Test" );

        when( reportHeaderRepository.findByType(any()) ).thenReturn( new ArrayList<ReportHeader>());
        when(reportHeaderRepository.save( any() )).thenReturn( reportHeader );

        ReportHeader reportHeader1 =  reportHeaderService.saveReport( reportHeader );

        assertEquals( reportHeader.getTitle(), reportHeader1.getTitle() );
        assertEquals( reportHeader.getCreationDate(), reportHeader1.getCreationDate() );
        assertEquals( reportHeader.getId(), reportHeader1.getId() );
    }

    @Test
    void testsaveReportBad() {
        Date date = new Date();

        ReportHeader reportHeader1 = new ReportHeader( 1, ReportHeader.TYPE.BALANCE_SHEET,
                date,1, "Test" );

        ReportHeader reportHeader2 = new ReportHeader( 1, ReportHeader.TYPE.BALANCE_SHEET,
                date,1, "Test" );

        List<ReportHeader> list = new ArrayList<ReportHeader>();
        list.add( reportHeader2 );

        when( reportHeaderRepository.findByType(any()) ).thenReturn( list );

        assertThrows(BalanceSheetReportException.class, () -> reportHeaderService.saveReport(reportHeader1) );
    }

    @Test
    void testFindAll() {
        Date date = new Date();

        ReportHeader reportHeader1 = new ReportHeader( 1, ReportHeader.TYPE.BALANCE_SHEET,
                date,1, "Test" );

        ReportHeader reportHeader2 = new ReportHeader( 1, ReportHeader.TYPE.BALANCE_SHEET,
                date,1, "Test" );

        List<ReportHeader> list = new ArrayList<ReportHeader>();
        list.add( reportHeader2 );
        list.add( reportHeader1 );

        when( reportHeaderRepository.findAll() ).thenReturn( list );

        List<ReportHeader> test2 = reportHeaderService.findAll(null);

        assertEquals( test2.hashCode(), list.hashCode() );
    }


}