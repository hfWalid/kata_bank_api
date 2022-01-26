package com.sg.soft.KataBankApp.controller;

import com.sg.soft.KataBankApp.common.dto.ResponseDTO;
import com.sg.soft.KataBankApp.dto.AccountDTO;
import com.sg.soft.KataBankApp.dto.StatementDTO;
import com.sg.soft.KataBankApp.service.AccountService;
import com.sg.soft.KataBankApp.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/statement")
public class StatementController {

    private final StatementService statementService;
    private final AccountService accountService;

    @Autowired
    public StatementController(StatementService statementService, AccountService accountService){
        this.statementService = statementService;
        this.accountService = accountService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO<List<StatementDTO>> getStatements(
            @RequestParam(value = "accountNumber", required = true) Long accountNumber,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "25") int size){
        ResponseDTO<List<StatementDTO>> response = new ResponseDTO<>();
        response.setMessage("Account number: ".concat(accountNumber.toString()));

        List<StatementDTO> statementsList = statementService.findAllByAccountNumber(accountNumber, page, size);

        //TODO: verify account is owned by authenticated client

        if(statementsList.size() > 0){
            response.setContent(statementsList);
        }
        response.setMessage(null);

        return response;
    }

    @PostMapping(path = "/deposit", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO<StatementDTO> makeDeposit(
            @RequestBody Long accountNumber,
            @RequestBody Double statementAmount
    ){
        ResponseDTO<StatementDTO> response = new ResponseDTO<>();
        response.setMessage("Account number: ".concat(accountNumber.toString()));

        //TODO: verify account is owned by authenticated client

        AccountDTO account = accountService.findAccountByAccountNumber(accountNumber);

        if(account == null){
            response.setContent(null);
            return response;
        }

        StatementDTO statement = statementService.makeDeposit(accountNumber, statementAmount);

        response.setContent(statement);
        return response;
    }

    @PostMapping(path = "/withdrawal", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO<StatementDTO> makeWithdrawal(
            @RequestBody Long accountNumber,
            @RequestBody Double statementAmount
    ){
        ResponseDTO<StatementDTO> response = new ResponseDTO<>();
        response.setMessage("Account number: ".concat(accountNumber.toString()));

        //TODO: verify account is owned by authenticated client

        AccountDTO account = accountService.findAccountByAccountNumber(accountNumber);

        if(account == null){
            response.setContent(null);
            return response;
        }

        StatementDTO statement = statementService.makeWithdrawal(accountNumber, statementAmount);

        response.setContent(statement);
        return response;
    }
}
