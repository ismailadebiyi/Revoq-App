package com.rateright.app.repo;

import com.rateright.app.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepo extends JpaRepository<Customers, Long> {
}
