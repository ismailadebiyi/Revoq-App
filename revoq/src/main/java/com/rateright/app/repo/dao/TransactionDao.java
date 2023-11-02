package com.rateright.app.repo.dao;

import com.rateright.app.model.Transactions;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TransactionDao {

    void addTransaction(Transactions transactions);
    List<Transactions> listAllTransactions();
    List<Transactions> listAllTransactionByCustomerId(Long customerId);
    Optional<Transactions> findTransactionById(Long txId);
    List<Transactions> listAllTransactionByDate(Date date);
}
