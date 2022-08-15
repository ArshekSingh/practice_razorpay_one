package com.example.practice_razorpay_one.repository;

import com.example.practice_razorpay_one.entity.LoanAccountMapping;
//import com.sts.merchant.core.entity.LoanAccountMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanAccountRepository extends JpaRepository<LoanAccountMapping, Integer> {
    @Query(value = "select * from loan_account_mapping where status =:status and loan_id =:loanId", nativeQuery = true)
    Optional<List<LoanAccountMapping>> findAllActiveLoanAccounts(String status, Integer loanId);
}
