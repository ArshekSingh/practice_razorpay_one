package com.example.practice_razorpay_one.repository;

import com.example.practice_razorpay_one.entity.LoanDetail;
//import com.sts.merchant.core.entity.LoanDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanDetailRepository extends JpaRepository<LoanDetail, Integer> {
    @Query(value = "SELECT * FROM loan_detail where status = :status" , nativeQuery = true)
    Optional<List<LoanDetail>> findActiveLoans(String status);
}
