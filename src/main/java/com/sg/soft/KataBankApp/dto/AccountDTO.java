package com.sg.soft.KataBankApp.dto;

import com.sg.soft.KataBankApp.model.KataUser;
import io.swagger.v3.oas.annotations.media.Schema;

public class AccountDTO {

    @Schema(description = "Unique identifier of the account.",
            example = "1234567890L", required = true)
    private Long accountNumber;

    @Schema(description = "The balance of the account.",
            example = "2300.00", required = false)
    private Double balance;

    @Schema(description = "The owner of the current account.",
            example = "1", required = true)
    private KataUser kataUser;

    public AccountDTO() {
    }

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
