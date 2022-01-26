package com.sg.soft.KataBankApp.statement;

import com.sg.soft.KataBankApp.common.dto.ResponseDTO;
import com.sg.soft.KataBankApp.controller.StatementController;
import com.sg.soft.KataBankApp.dto.AccountDTO;
import com.sg.soft.KataBankApp.dto.StatementDTO;
import com.sg.soft.KataBankApp.service.AccountService;
import com.sg.soft.KataBankApp.service.StatementService;
import com.sg.soft.KataBankApp.utils.Constants;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StatementTests {

    private MockMvc mockMvc;

    @Mock
    private StatementService statementService;

    @Mock
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        StatementController statementController = new StatementController(statementService, accountService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(statementController).build();
    }

    @Test
    public void shouldGetStatementsTest() throws Exception {
        ResponseDTO<List<StatementDTO>> response = new ResponseDTO<>(ResponseDTO.SUCCESS, null);

        AccountDTO accountDTO = new AccountDTO(Constants.ACCOUNT_NUMBER, Constants.STATEMENT_AMOUNT);
        StatementDTO statementDTO = new StatementDTO(1L, new Date(), Constants.STATEMENT_AMOUNT, Constants.DEPOSIT, accountDTO);

        List<StatementDTO> expectedStatementsList = Arrays.asList(statementDTO);

        response.setContent(expectedStatementsList);

        when(statementService.findAllByAccountNumber(Constants.ACCOUNT_NUMBER, Constants.PAGE_NUMBER, Constants.PAGE_SIZE))
                .thenReturn(expectedStatementsList);

        assertEquals(expectedStatementsList.size(), 1);
        assertEquals(expectedStatementsList.get(0).getAccount().getAccountNumber(), Constants.ACCOUNT_NUMBER);
        assertEquals(expectedStatementsList.get(0).getStatementAmount(), Constants.STATEMENT_AMOUNT);

        this.mockMvc.perform(get("/statement/?accountNumber=1234567890")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(1)))
                .andExpect(jsonPath("$.content[0].statementAmount", Matchers.is(Constants.STATEMENT_AMOUNT)))
                .andExpect(jsonPath("$.content[0].account.accountNumber", Matchers.is(Constants.ACCOUNT_NUMBER)));

    }



}
