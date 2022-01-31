package com.sg.soft.KataBankApp.utils;

import org.junit.Ignore;

import java.math.BigDecimal;

@Ignore
public class Constants {


    public static final Long ACCOUNT_NUMBER = Long.valueOf(1234567890);
    public static final Long WRONG_ACCOUNT_NUMBER = Long.valueOf(123);
    public static final BigDecimal BALANCE = new BigDecimal(10000);

    public static final String DEPOSIT = "DEPOSIT";
    public static final String WITHDRAWAL = "WITHDRAWAL";

    public static final BigDecimal STATEMENT_AMOUNT = new BigDecimal(3000);

    public static final Integer PAGE_NUMBER = 0;
    public static final Integer PAGE_SIZE = 25;
}
