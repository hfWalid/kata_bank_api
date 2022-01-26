package com.sg.soft.KataBankApp.service.impl;

import com.sg.soft.KataBankApp.dto.AccountDTO;
import com.sg.soft.KataBankApp.model.Account;
import com.sg.soft.KataBankApp.repository.AccountRepository;
import com.sg.soft.KataBankApp.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private final ModelMapper modelMapper;
    private final AccountRepository accountRepository;

    public AccountServiceImpl(ModelMapper modelMapper, AccountRepository accountRepository){
        this.modelMapper = modelMapper;
        this.accountRepository = accountRepository;
    }

    public AccountDTO findAccountByAccountNumber(Long accountNumber) {
        Account account = accountRepository.findFirstByAccountNumber(accountNumber);

        if(account == null || account.getId() == null){
            return null;
        }
        return modelMapper.map(account, AccountDTO.class);
    }
}
