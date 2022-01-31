package com.sg.soft.KataBankApp.dto;

import java.math.BigDecimal;

public class StatementRequestDTO {

    private Long accountNumber;
    private BigDecimal statementAmount;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getStatementAmount() {
        return statementAmount;
    }

    public void setStatementAmount(BigDecimal statementAmount) {
        this.statementAmount = statementAmount;
    }
}
