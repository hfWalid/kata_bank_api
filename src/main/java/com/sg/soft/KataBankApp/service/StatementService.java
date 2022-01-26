package com.sg.soft.KataBankApp.service;

import com.sg.soft.KataBankApp.dto.StatementDTO;

import java.util.List;

public interface StatementService {
    List<StatementDTO> findAllByAccountNumber(Long accountNumber, Integer page, Integer size);

    StatementDTO makeDeposit(Long accountNumber, Double amount);

    StatementDTO makeWithdrawal(Long accountNumber, Double amount);
}
