package com.rateright.app.controllers;

import com.rateright.app.model.Users;
import com.rateright.app.requests.UserCreationRequest;
import com.rateright.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@Slf4j
public class UserController {

    //TODO: createUser, editUserDetails, disableStaff, getAllStaffs, getStaffByStaffId,,
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody UserCreationRequest userCreationRequest){

        log.info("New Staff creation {}", userCreationRequest);
        userService.createUser(userCreationRequest);
    }

    @GetMapping
    public List<Users> getAllUsers(){

        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Users getUserById(@PathVariable Long userId){

        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public void updateUserDetails(@PathVariable String userId){

    }

    @PostMapping("/{userId}")
    public void disableUser(@PathVariable String userId){

    }


}
