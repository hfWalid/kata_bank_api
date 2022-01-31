package com.sg.soft.KataBankApp.service;

import com.sg.soft.KataBankApp.dto.StatementDTO;

import java.math.BigDecimal;
import java.util.List;

public interface StatementService {
    List<StatementDTO> findAllByAccountNumber(Long accountNumber, Integer page, Integer size);

    StatementDTO makeDeposit(Long accountNumber, BigDecimal amount);

    StatementDTO makeWithdrawal(Long accountNumber, BigDecimal amount);
}
