package com.example.demo.exception;

public class NoReportException extends RuntimeException {
    public NoReportException() {
        super("The report header does not exist");
    }
}
