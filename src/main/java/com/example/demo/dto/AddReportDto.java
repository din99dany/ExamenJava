package com.example.demo.dto;


import com.example.demo.model.ReportHeader;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

public class AddReportDto {

    public AddReportDto(ReportHeader.TYPE type, Date creationDate, int creationUser, String title) {
        this.type = type;
        this.creationDate = creationDate;
        this.creationUser = creationUser;
        this.title = title;
    }

    public AddReportDto(){}

    @Enumerated( EnumType.STRING )
    private ReportHeader.TYPE type;

    @NotNull
    @Past
    private Date creationDate;

    @NotNull
    @Positive
    private int creationUser;

    @NotBlank
    @Size( max = 200 )
    private String title;

    public ReportHeader.TYPE getType() {
        return type;
    }

    public void setType(ReportHeader.TYPE type) {
        this.type = type;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(int creationUser) {
        this.creationUser = creationUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
