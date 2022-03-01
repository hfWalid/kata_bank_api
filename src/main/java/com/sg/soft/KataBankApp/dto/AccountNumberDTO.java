package com.sg.soft.KataBankApp.dto;

public class AccountNumberDTO {

    private Long bankCode;

    private Long atmCode;

    private Long ribKey;

    private Long ibanNumber;

    private Long swiftCode;

    public AccountNumberDTO(Long bankCode, Long atmCode, Long ribKey, Long ibanNumber, Long swiftCode) {
        this.bankCode = bankCode;
        this.atmCode = atmCode;
        this.ribKey = ribKey;
        this.ibanNumber = ibanNumber;
        this.swiftCode = swiftCode;
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
