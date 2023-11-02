package com.rateright.app.repo.dataAccessServices;

import com.rateright.app.model.Users;
import com.rateright.app.repo.UserRepo;
import com.rateright.app.repo.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userJpa")
public class UsersJpaDataAccessService implements UserDao {

    private final UserRepo userRepo;

    public UsersJpaDataAccessService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<Users> selectAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<Users> selectUsersById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public String getUserEmail() {
        return null;
    }

    @Override
    public void createUser(Users users) {

    }
}
