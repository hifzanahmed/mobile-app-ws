package com.mobileApp.ws.mobileappws.ui.controller;

import com.mobileApp.ws.mobileappws.model.request.UserDetailsRequestModel;
import com.mobileApp.ws.mobileappws.model.response.UserRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")  //  http://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUser() {
        return "get User API was called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){
        return new UserRest();
    }

    @PutMapping
    public String updateUser(){
        return "update/Put user API was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user API was called";
    }
}
