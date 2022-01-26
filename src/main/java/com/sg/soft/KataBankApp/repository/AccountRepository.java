package com.sg.soft.KataBankApp.repository;

import com.sg.soft.KataBankApp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findFirstByAccountNumber(Long accountNumber);

}
