package com.rateright.app.repo.dao;

import com.rateright.app.model.Customers;
import com.rateright.app.model.Users;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<Users> selectAllUsers();
    Optional<Users> selectUsersById(Long id);
    String getUserEmail();
    void createUser(Users users);
}
