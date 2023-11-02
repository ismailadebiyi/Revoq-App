package com.rateright.app.repo;

import com.rateright.app.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<Users, Long> {
}
