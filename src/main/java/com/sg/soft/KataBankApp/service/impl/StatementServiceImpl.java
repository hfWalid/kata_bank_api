package com.sg.soft.KataBankApp.service.impl;

import com.sg.soft.KataBankApp.dto.StatementDTO;
import com.sg.soft.KataBankApp.model.Account;
import com.sg.soft.KataBankApp.model.Statement;
import com.sg.soft.KataBankApp.repository.AccountRepository;
import com.sg.soft.KataBankApp.repository.StatementRepository;
import com.sg.soft.KataBankApp.service.StatementService;
import com.sg.soft.KataBankApp.common.utils.Constants;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StatementServiceImpl implements StatementService {
    private final static Logger LOGGER = LoggerFactory.getLogger(StatementServiceImpl.class);

    private final StatementRepository statementRepository;
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StatementServiceImpl(
            StatementRepository statementRepository,
            AccountRepository accountRepository,
            ModelMapper modelMapper){
        this.statementRepository = statementRepository;
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }


    public List<StatementDTO> findAllByAccountNumber(Long accountNumber, Integer page, Integer size){
        LOGGER.info("StatementService -> Get all statements done for account" + accountNumber);

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "statementDate"));

        List<Statement> statementsList = statementRepository.findAllByAccount_AccountNumber(accountNumber, pageRequest);

        List<StatementDTO> resultList = statementsList.stream()
                .map(statement -> modelMapper.map(statement, StatementDTO.class))
                //.sorted(Comparator.comparing(StatementDTO::getStatementDate))
                .collect(Collectors.toList());
        return resultList;
    };

    public StatementDTO makeDeposit(Long accountNumber, Double statementAmount){
        LOGGER.info("StatementService -> make deposit for account ".concat(accountNumber.toString()).concat(" of amount ".concat(statementAmount.toString())));

        Account finalAccount;
        Statement statement = null;

        Account account = accountRepository.findFirstByAccountNumber(accountNumber);
        try{
            finalAccount = account;

            statement = new Statement(statementAmount, Constants.DEPOSIT, account);
            statementRepository.save(statement);

            finalAccount.setBalance(account.getBalance() + statementAmount);
            BeanUtils.copyProperties(finalAccount, account);
            accountRepository.save(account);

        }catch (Exception exception){
            LOGGER.info(exception.getMessage());
            System.out.println(exception.getMessage());
        }
        return modelMapper.map(statement, StatementDTO.class);
    };

    public StatementDTO makeWithdrawal(Long accountNumber, Double statementAmount){
        LOGGER.info("StatementService -> make withdrawal for account ".concat(accountNumber.toString()).concat(" of amount ".concat(statementAmount.toString())));

        Account finalAccount;
        Statement statement = null;

        Account account = accountRepository.findFirstByAccountNumber(accountNumber);
        try{
            finalAccount = account;

            if(account.getBalance().compareTo(statementAmount) < 0){
                statement = new Statement(statementAmount, Constants.WITHDRAWAL, account);
                statementRepository.save(statement);

                finalAccount.setBalance(account.getBalance() - statementAmount);
                BeanUtils.copyProperties(finalAccount, account);
                accountRepository.save(account);
            }
        }catch(Exception exception){
            LOGGER.info(exception.getMessage());
            System.out.println(exception.getMessage());
        }
        return modelMapper.map(statement, StatementDTO.class);
    };
}
