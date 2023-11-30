package com.rateright.app.repo.dataAccessServices;

import com.rateright.app.model.Customers;
import com.rateright.app.model.Transactions;
import com.rateright.app.repo.TransactionRepo;
import com.rateright.app.repo.dao.TransactionDao;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository("transactionJpa")
public class TransactionJPADataAccessServices implements TransactionDao {

    private final TransactionRepo transactionRepo;

    public TransactionJPADataAccessServices(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public void addTransaction(Transactions transactions) {
        transactionRepo.save(transactions);
    }

    @Override
    public List<Transactions> listAllTransactions() {
        return transactionRepo.findAll();
    }

    @Override
    public List<Transactions> listAllTransactionByCustomerId(Long customerId) {
        return transactionRepo.findAllTransactionsByCustomers_CustomerId(customerId);
    }

    @Override
    public Optional<Transactions> findTransactionById(Long txId) {
        return transactionRepo.findById(txId);
    }

//    @Override
//    public List<Transactions> listAllTransactionByDate(Date date) {
//        return transactionRepo.findAllTransactionsByTxTime(date);
//    }
}
