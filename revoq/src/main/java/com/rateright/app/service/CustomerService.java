package com.rateright.app.service;

import com.rateright.app.exceptions.ResourceNotFoundException;
import com.rateright.app.model.Customers;
import com.rateright.app.model.Transactions;
import com.rateright.app.repo.dao.CustomerDao;
import com.rateright.app.requests.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    public final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void registerCustomer(CustomerRegistrationRequest request){
        //Todo: check for email in db
        //
        Customers customer = Customers.builder()
                .companyName(request.companyName())
                .email(request.email())
                .phoneNumber(request.phoneNumber())
                .avatar(request.avatar())
                .build();

        customerDao.addCustomer(customer);
    }

    public List<Customers> getAllCustomers(){

        return customerDao.getAllCustomers();
    }

    public Customers getCustomersById(Long customerId){
        return customerDao.getCustomerById(customerId).
                orElseThrow(()-> new ResourceNotFoundException("Customer Not Found"));
    }

    public void deleteCustomerById(Long customerId){
        customerDao.deleteCustomerById(customerId);
    }

}
