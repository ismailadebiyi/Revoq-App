package com.rateright.app.controllers;


import com.rateright.app.requests.CustomerRegistrationRequest;
import com.rateright.app.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /*TODO:
       addCustomers,
       editCustomerDetails,
       showAllCustomers,
       deleteCustomerById,
       viewCustomerById,
       allWithUserId
     */

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        log.info("New Customer Registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }
}
