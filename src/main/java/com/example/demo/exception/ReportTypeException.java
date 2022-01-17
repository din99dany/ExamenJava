package com.example.demo.exception;

public class ReportTypeException extends RuntimeException {
    public ReportTypeException() {
        super("Bad type to search");
    }
}
