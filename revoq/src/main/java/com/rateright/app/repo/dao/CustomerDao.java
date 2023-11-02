package com.rateright.app.repo.dao;


import com.rateright.app.model.Customers;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    void addCustomer(Customers customers);
    List<Customers> getAllCustomers();
    Optional<Customers> getCustomerById(Long customerId);
    void deleteCustomerById(Long customerId);



}
