package com.sg.soft.KataBankApp.dto;

import com.sg.soft.KataBankApp.model.KataUser;

public class AccountDTO {

    private Long accountNumber;
    private Double balance;
    private KataUser kataUser;

    public AccountDTO(Long accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public KataUser getKataUser() {
        return kataUser;
    }

    public void setKataUser(KataUser kataUser) {
        this.kataUser = kataUser;
    }
}
