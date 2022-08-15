package com.example.practice_razorpay_one.service.serviceimpl;

import com.example.practice_razorpay_one.entity.*;
import com.example.practice_razorpay_one.enums.Collection;
import com.example.practice_razorpay_one.mapper.RazorpayTransferMapper;
import com.example.practice_razorpay_one.repository.CollectionRepository;
import com.example.practice_razorpay_one.service.CollectionService;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Transfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionRepository collectionRepository;

    public CollectionServiceImpl(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    @Autowired
    private RazorpayTransferMapper razorpayTransferMapper;

//    @Override
//    public CollectionDetail saveCollection(LoanDetail loanDetail, Integer collectionSequence, TransactionDetail transaction, BigDecimal amountToBeCollected) {
//        Optional<CollectionDetail> existingCollection = collectionRepository.findExistingCollectionByTxn(loanDetail.getLoanId(), transaction.getTransactionId());
//        if (existingCollection.isEmpty()) {
//            CollectionDetail collectionDetail = new CollectionDetail();
//            collectionDetail.setCollectionAmount(amountToBeCollected);
//            collectionDetail.setCollectionDate(LocalDateTime.ofInstant(LocalDateTime.now().toInstant(ZoneOffset.UTC), ZoneId.systemDefault()));
//            collectionDetail.setCollectionDetailPK(new CollectionDetailPK(collectionSequence, loanDetail.getLoanId()));
//            collectionDetail.setStatus(Collection.PENDING.toString());
//            collectionDetail.setCollectionType(transaction.getTransactionMode());
//            collectionDetail.setTransactionId(transaction.getTransactionId());
//            collectionDetail.setCreatedBy("JOB");
//            collectionDetail.setCreatedOn(LocalDateTime.ofInstant(LocalDateTime.now().toInstant(ZoneOffset.UTC), ZoneId.systemDefault()));
//            collectionDetail = collectionRepository.save(collectionDetail);
//            return collectionDetail;
//        } else {
//            return existingCollection.get();
//        }
//    }

    public Optional<List<CollectionDetail>> findByTransferId(){
        Optional<List<CollectionDetail>> collectionDetails = collectionRepository.findCollectionByTransferId("trf_K4cbFaSj4mXcy5");

        if(collectionDetails.isEmpty()){
            log.info("There is no such record found");

        } else {
            for(CollectionDetail collectionDetail: collectionDetails.get()){
                RazorpayClient razorpay = null;
                try {
                    razorpay = new RazorpayClient("rzp_test_9bS6OTCEBbOIUk", "ATwiBqhJoLo2TIy1pMkILX39");

                    Transfer transfer = razorpay.transfers.fetch(collectionDetail.getTransferId());
                    RazorpayTransfer razorpayTransferrpay = razorpayTransferMapper.mapTransfer(transfer);

                    System.out.println(razorpayTransferrpay);
                } catch (RazorpayException e) {
                    throw new RuntimeException(e);
                }


            }
        }
        System.out.println(collectionDetails.toString());

        return collectionDetails;
    }
}
