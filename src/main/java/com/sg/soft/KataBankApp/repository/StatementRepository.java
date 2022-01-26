package com.sg.soft.KataBankApp.repository;

import com.sg.soft.KataBankApp.model.Statement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Long> {

    List<Statement> findByAccountAccountNumber(Long accountNumber, Pageable pageRequest);

}
