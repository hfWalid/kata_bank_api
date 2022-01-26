package com.sg.soft.KataBankApp.dto;

public class StatementRequestDTO {

    private Long accountNumber;
    private Double statementAmount;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getStatementAmount() {
        return statementAmount;
    }

    public void setStatementAmount(Double statementAmount) {
        this.statementAmount = statementAmount;
    }
}
