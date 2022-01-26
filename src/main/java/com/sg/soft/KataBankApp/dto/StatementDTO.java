package com.sg.soft.KataBankApp.dto;

import java.util.Date;

public class StatementDTO {

    private Long id;

    private Date statementDate;

    private Double statementAmount;

    private String statementType;

    private AccountDTO account;

    public StatementDTO() {
    }

    public StatementDTO(Long id, Date statementDate, Double statementAmount, String statementType, AccountDTO account) {
        this.id = id;
        this.statementDate = statementDate;
        this.statementAmount = statementAmount;
        this.statementType = statementType;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(Date statementDate) {
        this.statementDate = statementDate;
    }

    public Double getStatementAmount() {
        return statementAmount;
    }

    public void setStatementAmount(Double statementAmount) {
        this.statementAmount = statementAmount;
    }

    public String getStatementType() {
        return statementType;
    }

    public void setStatementType(String statementType) {
        this.statementType = statementType;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }
}
