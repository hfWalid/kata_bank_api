package com.sg.soft.KataBankApp.model;

import javax.persistence.*;


@Entity
@Table(name = "account_number")
public class AccountNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "bank_code", unique = true, nullable = false)
    private Long bankCode;

    @Column(name = "atm_code", unique = true, nullable = false)
    private Long atmCode;

    @Column(name = "rib_key", unique = true, nullable = false)
    private Long ribKey;

    @Column(name = "iban_number", unique = true, nullable = false)
    private Long ibanNumber;

    @Column(name = "swift_code", unique = true, nullable = false)
    private Long swiftCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBankCode() {
        return bankCode;
    }

    public void setBankCode(Long bankCode) {
        this.bankCode = bankCode;
    }

    public Long getAtmCode() {
        return atmCode;
    }

    public void setAtmCode(Long atmCode) {
        this.atmCode = atmCode;
    }

    public Long getRibKey() {
        return ribKey;
    }

    public void setRibKey(Long ribKey) {
        this.ribKey = ribKey;
    }

    public Long getIbanNumber() {
        return ibanNumber;
    }

    public void setIbanNumber(Long ibanNumber) {
        this.ibanNumber = ibanNumber;
    }

    public Long getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(Long swiftCode) {
        this.swiftCode = swiftCode;
    }
}
