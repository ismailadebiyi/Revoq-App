package com.rateright.app.repo;


import com.rateright.app.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface TransactionRepo extends JpaRepository<Transactions, Long> {

    List<Transactions> findAllTransactionsByCustomers_CustomerId(Long customersId);


}
