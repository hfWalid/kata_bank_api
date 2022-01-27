package com.sg.soft.KataBankApp.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class StatementDTO {

    private Long id;

    @Schema(description = "Exact timestamp when the statement was created at.",
            example = "2011-11-11T17:30:00", required = true)
    private Date statementDate;

    @Schema(description = "The amount of money the account was debited when the statement was created .",
            example = "100", required = true)
    private Double statementAmount;

    @Schema(description = "TType of statement if it is about a deposit or withdrawal.",
            example = "DEPOSIT", required = true)
    private String statementType;

    @Schema(description = "The account of whitch the statement is related to.",
            example = "3", required = true)
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
