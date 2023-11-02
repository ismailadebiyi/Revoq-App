package com.rateright.app.controllers;

import com.rateright.app.requests.CreateTransactionRequest;
import com.rateright.app.service.TransactionServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1/transaction")
public class TransactionController {

    private final TransactionServices transactionServices;

    public TransactionController(TransactionServices transactionServices) {
        this.transactionServices = transactionServices;
    }
    /*TODO: viewAllTransactions,
       viewAllTransactionByDate,
       viewAllTransactionsByCustomerId,
       SendReviewLinkToEmailAndPhoneNo
       selectTransactionById
    */


    @PostMapping
    public void createTransaction(@RequestBody CreateTransactionRequest request){
        log.info("New TransactionRequest {}", request);
        transactionServices.createTransaction(request);
    }
}
