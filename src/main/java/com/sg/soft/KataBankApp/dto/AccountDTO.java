package com.sg.soft.KataBankApp.dto;

import com.sg.soft.KataBankApp.model.KataUser;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public class AccountDTO {

    @Schema(description = "Unique identifier of the account, composed of rib, ribKey, atmCode and iban and swift code.",
            example = "1234567890", required = true)
    private AccountNumberDTO accountNumber;

    @Schema(description = "The balance of the account.",
            example = "2300.00", required = false)
    private BigDecimal balance;

    @Schema(description = "The owner of the current account.",
            example = "1", required = true)
    private KataUser kataUser;

    public AccountDTO() {
    }

    public AccountDTO(AccountNumberDTO accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public AccountNumberDTO getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(AccountNumberDTO accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public KataUser getKataUser() {
        return kataUser;
    }

    public void setKataUser(KataUser kataUser) {
        this.kataUser = kataUser;
    }
}
