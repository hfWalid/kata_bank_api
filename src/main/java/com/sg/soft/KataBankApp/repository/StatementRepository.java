package com.sg.soft.KataBankApp.repository;

import com.sg.soft.KataBankApp.model.Statement;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Long> {

    List<Statement> findAllByAccount_AccountNumber(Long accountNumber, PageRequest pageRequest);

}
