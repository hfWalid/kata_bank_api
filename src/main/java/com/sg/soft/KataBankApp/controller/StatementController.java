package com.sg.soft.KataBankApp.controller;

import com.sg.soft.KataBankApp.common.dto.ResponseDTO;
import com.sg.soft.KataBankApp.dto.AccountDTO;
import com.sg.soft.KataBankApp.dto.StatementDTO;
import com.sg.soft.KataBankApp.dto.StatementRequestDTO;
import com.sg.soft.KataBankApp.model.Statement;
import com.sg.soft.KataBankApp.service.AccountService;
import com.sg.soft.KataBankApp.service.StatementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statement")
public class StatementController {

    private final StatementService statementService;
    private final AccountService accountService;

    @Autowired
    public StatementController(StatementService statementService, AccountService accountService){
        this.statementService = statementService;
        this.accountService = accountService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Retrieve statements history already done, sorted by date wth a pagination option", description = "pagination is set to page=0 and size=25 by default ", tags = { "Statements" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful request")})
    public ResponseDTO<List<StatementDTO>> getStatements(
            @RequestParam(value = "accountNumber") Long accountNumber,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "25") int size){
        ResponseDTO<List<StatementDTO>> response = new ResponseDTO<>(ResponseDTO.SUCCESS, null);


        List<StatementDTO> statementsList = this.statementService.findAllByAccountNumber(accountNumber, page, size);

        //TODO: verify account is owned by authenticated client

        response.setContent(statementsList);
        return response;
    }

    @PostMapping( "/deposit")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Make a deposit to account", description = "Needs an account number, and a statement amount ", tags = { "Statements" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful request")})
    public ResponseDTO<StatementDTO> deposit(@RequestBody StatementRequestDTO statementRequestDTO){
        ResponseDTO<StatementDTO> response = new ResponseDTO<>(ResponseDTO.SUCCESS, null);
        response.setMessage("Account number: ".concat(statementRequestDTO.getAccountNumber().toString()));

        //TODO: verify account is owned by authenticated client

        AccountDTO account = accountService.findAccountByAccountNumber(statementRequestDTO.getAccountNumber());

        if(account == null){
            response.setContent(null);
            return response;
        }

        StatementDTO statement = statementService.makeDeposit(statementRequestDTO.getAccountNumber(), statementRequestDTO.getStatementAmount());

        response.setContent(statement);
        return response;
    }

    @PostMapping( "/withdrawal")
    @ResponseStatus(HttpStatus.OK)@Operation(summary = "Make a withdrawal from account, if balance < statement amount fails", description = "Needs an account number and a statement amount", tags = { "Statements" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful request")})
    public ResponseDTO<StatementDTO> makeWithdrawal(
            @RequestBody StatementRequestDTO statementRequestDTO){
        ResponseDTO<StatementDTO> response = new ResponseDTO<>(ResponseDTO.SUCCESS, null);
        response.setMessage("Account number: ".concat(statementRequestDTO.getStatementAmount().toString()));

        //TODO: verify account is owned by authenticated client

        AccountDTO account = accountService.findAccountByAccountNumber(statementRequestDTO.getAccountNumber());

        if(account == null){
            response.setContent(null);
            return response;
        }

        StatementDTO statement = statementService.makeWithdrawal(statementRequestDTO.getAccountNumber(), statementRequestDTO.getStatementAmount());

        response.setContent(statement);
        return response;
    }
}
