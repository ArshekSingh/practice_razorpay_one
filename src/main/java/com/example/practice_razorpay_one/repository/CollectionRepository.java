package com.example.practice_razorpay_one.repository;

import com.example.practice_razorpay_one.entity.CollectionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CollectionRepository extends JpaRepository<CollectionDetail, Integer> {

    @Query(value = "SELECT MAX(coll_seq) FROM collection_detail where loan_id =:loanId and status =:status", nativeQuery = true)
    Optional<Integer> findCollectionSequenceCount(Integer loanId, String status);

    @Query(value = "SELECT * FROM collection_detail where loan_id =:loanId and txn_id =:txnId", nativeQuery = true)
    Optional<CollectionDetail> findExistingCollectionByTxn(Integer loanId, String txnId);

    @Query(value = "SELECT * FROM collection_detail WHERE transfer_id=:transferId", nativeQuery = true)
    Optional<List<CollectionDetail>> findCollectionByTransferId(String transferId);


    @Modifying
    @Query(value = "UPDATE collection_detail set status = :collectionStatus where loan_id = :loanId and coll_seq =:collectionSequence", nativeQuery = true)
    void updateCollectionStatusByCollectionId(String collectionStatus, Integer loanId, Integer collectionSequence);
}
