package com.sg.soft.KataBankApp.statement;

import com.sg.soft.KataBankApp.controller.StatementController;
import com.sg.soft.KataBankApp.service.AccountService;
import com.sg.soft.KataBankApp.service.StatementService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@ContextConfiguration
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
    void shouldGetStatementsTest() throws Exception {

    }
    @Test
    void should_Not_GetStatementsTest() throws Exception {

    }
    @Test
    void shouldMakeDepositTest() throws Exception {

    }
    @Test
    void shouldMakeWithdrawalTest() throws Exception {

    }
    @Test
    void should_Not_MakeWithdrawalTest() throws Exception {

    }

}
