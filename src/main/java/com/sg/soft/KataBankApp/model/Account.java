package com.sg.soft.KataBankApp.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //TODO: should be devided to: Rib: bankCode + atmCode + accountNumber + ribKey  // IBAN unique // swiftCode
    @Column(name = "account_number", unique = true, nullable = false)
    private Long accountNumber;

    @Column(name = "balance")
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "kata_user_id")
    @OrderBy("id")
    private KataUser kataUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
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
