package com.mobileApp.ws.mobileappws.serviceImpl;

import com.mobileApp.ws.mobileappws.UserRepository;
import com.mobileApp.ws.mobileappws.entity.UserEntity;
import com.mobileApp.ws.mobileappws.service.UserService;
import com.mobileApp.ws.mobileappws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto user){

        //copy input data to userentity
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        //add some column values
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");
        //save input data to table and return saved data
        UserEntity storedUserDetails = userRepository.save(userEntity);

        //get return data in dto
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }
}
