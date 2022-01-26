package com.sg.soft.KataBankApp.repository;

import com.sg.soft.KataBankApp.model.Statement;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatementRepository extends JpaRepository<Statement, Long> {

    List<Statement> findAllByAccount_AccountNumber(Long accountNumber, PageRequest pageRequest);

}
