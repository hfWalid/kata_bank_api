package com.sg.soft.KataBankApp.service;

import com.sg.soft.KataBankApp.dto.AccountDTO;

public interface AccountService {
    AccountDTO findAccountByAccountNumber(Long accountNumber);
}
