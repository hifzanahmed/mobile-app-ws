package com.mobileApp.ws.mobileappws.ui.controller;

import com.mobileApp.ws.mobileappws.model.request.UserDetailsRequestModel;
import com.mobileApp.ws.mobileappws.model.response.UserRest;
import com.mobileApp.ws.mobileappws.service.UserService;
import com.mobileApp.ws.mobileappws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")  //  http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser() {
        return "get User API was called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createUser, returnValue);
        return returnValue;
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
