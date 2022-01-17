package com.example.demo.exception;

public class BalanceSheetReportException extends RuntimeException {

    public BalanceSheetReportException() {
        super("“There is already a BALANCE_SHEET report for \n" +
                "the specified date");
    }
}
