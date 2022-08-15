package com.example.practice_razorpay_one.repository;

import com.example.practice_razorpay_one.entity.TransactionDetail;
//import com.sts.merchant.core.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetail, Integer> {
    @Query(value = "select * from transaction_detail where status =:status and loan_id =:loanId and loan_account_map_id =:accountId", nativeQuery = true)
    Optional<List<TransactionDetail>> findAllCapturedTransactionsByLoanAndAccount(String status, Integer loanId, Integer accountId);

    @Query(value = "select * from transaction_detail where txn_id =:transactionId", nativeQuery = true)
    Optional<TransactionDetail> findTransactionById(String transactionId);

    @Query(value = "select * from transaction_detail where loan_id =:loanId and loan_account_map_id =:accountId ORDER BY txn_date DESC LIMIT 1", nativeQuery = true)
    Optional<TransactionDetail> findLastTransactionByLoanAndAccount(Integer loanId, Integer accountId);

    @Modifying
    @Query(value = "UPDATE transaction_detail set status = :transactionStatus where id =:transactionId", nativeQuery = true)
    void updateTransactionStatusById(String transactionStatus, Integer transactionId);
}
