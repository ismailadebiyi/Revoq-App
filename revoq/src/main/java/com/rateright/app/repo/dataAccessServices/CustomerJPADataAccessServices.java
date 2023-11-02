package com.rateright.app.repo.dataAccessServices;

import com.rateright.app.model.Customers;
import com.rateright.app.repo.CustomerRepo;
import com.rateright.app.repo.dao.CustomerDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("customerJpa")
public class CustomerJPADataAccessServices implements CustomerDao {

    private final CustomerRepo customerRepo;

    public CustomerJPADataAccessServices(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public void addCustomer(Customers customers) {
        customerRepo.save(customers);
    }

    @Override
    public List<Customers> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Optional<Customers> getCustomerById(Long customerId) {
        return customerRepo.findById(customerId);
    }
    @Override
    public void deleteCustomerById(Long customerId) {

        customerRepo.deleteById(customerId);

    }
}
