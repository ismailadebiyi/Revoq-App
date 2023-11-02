package com.rateright.app.service;

import com.rateright.app.exceptions.ResourceNotFoundException;
import com.rateright.app.model.Transactions;
import com.rateright.app.repo.dao.TransactionDao;
import com.rateright.app.requests.CreateTransactionRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.assertj.core.util.DateUtil.now;

@Service
public class TransactionServices {

    private final TransactionDao transactionDao;

    public TransactionServices(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    //TODO: SendReviewLinkToCustomerEmailAndPhoneNo
    public void createTransaction(CreateTransactionRequest transactionRequest){
        Transactions transactions = Transactions.builder()
                .customerId(transactionRequest.customerId())
                .txDetails(transactionRequest.transactionDetails())
                .reviewLink(getTransactionUri())
                .txTime(now())
                .build();
        transactionDao.addTransaction(transactions);
    }
    public List<Transactions> viewAllTransactions(){
        return transactionDao.listAllTransactions();
    }

    public List<Transactions> viewAllTransactionByDate(Date date){
        return transactionDao.listAllTransactionByDate(date);
    }

    public Transactions viewTransactionById(Long txId){
        return transactionDao.findTransactionById(txId)
                .orElseThrow(()-> new ResourceNotFoundException("Transaction Details Not Found"));
    }

    public List<Transactions> viewAllTransactionByCustomerId(Long customerId){
        return transactionDao.listAllTransactionByCustomerId(customerId);
    }

    public String getTransactionUri(){
        return "https://transactionlink.com/review?";
    }
}
