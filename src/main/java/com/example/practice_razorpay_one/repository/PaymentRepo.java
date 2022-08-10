package com.example.practice_razorpay_one.repository;

import com.example.practice_razorpay_one.entity.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepo extends JpaRepository<PaymentDetails, Long> {

}
