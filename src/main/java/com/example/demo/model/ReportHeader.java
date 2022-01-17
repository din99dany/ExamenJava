package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "report_header")
public class ReportHeader {

    public ReportHeader(long id, TYPE type, Date creationDate, int creationUser, String title) {
        this.id = id;
        this.type = type;
        this.creationDate = creationDate;
        this.creationUser = creationUser;
        this.title = title;
    }

    public ReportHeader(TYPE type, Date creationDate, int creationUser, String title) {
        this.type = type;
        this.creationDate = creationDate;
        this.creationUser = creationUser;
        this.title = title;
    }

    public ReportHeader(){}

    public enum TYPE {
        BALANCE_SHEET,
        PROFIT_AND_LOSS,
        CASH_FLOW
    };

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    @Enumerated( EnumType.STRING )
    private TYPE type;

    @Column
    @NotNull
    private Date creationDate;

    @Column
    @NotNull
    @Positive
    private int creationUser;

    @Column
    @NotNull
    @Size( max = 200 )
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
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
