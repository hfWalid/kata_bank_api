package com.sg.soft.KataBankApp.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "statement")
public class Statement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "statement_date")
    private Date statementDate;

    @Column(name = "statement_amount", unique = true, nullable = false)
    private BigDecimal statementAmount;

    @Column(name = "statement_type")
    private String statementType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account", referencedColumnName = "id")
    private Account account;

    public Statement() {}

    public Statement(BigDecimal statementAmount, String statementType, Account account) {
        this.statementDate = new Date();
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

    public BigDecimal getStatementAmount() {
        return statementAmount;
    }

    public void setStatementAmount(BigDecimal statementAmount) {
        this.statementAmount = statementAmount;
    }

    public String getStatementType() {
        return statementType;
    }

    public void setStatementType(String statementType) {
        this.statementType = statementType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
