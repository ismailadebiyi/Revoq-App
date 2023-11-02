package com.rateright.app.service;

import com.rateright.app.exceptions.ResourceNotFoundException;
import com.rateright.app.model.Users;
import com.rateright.app.repo.dao.UserDao;
import com.rateright.app.requests.UserCreationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public void createUser(UserCreationRequest request){
        Users users = Users.builder()
                .businessName(request.firstName())
                .contactPersonName(request.lastName())
                .password(request.password())
                .businessEmail(request.email())
                .build();

        userDao.createUser(users);
    }

    public List<Users> getAllUsers(){
        return userDao.selectAllUsers();
    }

    public Users getUserById(Long id){

        return userDao.selectUsersById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
    }
}
