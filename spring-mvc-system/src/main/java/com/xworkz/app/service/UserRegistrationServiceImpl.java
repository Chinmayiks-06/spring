package com.xworkz.app.service;

import com.xworkz.app.dto.UserDto;
import com.xworkz.app.repository.UserRegistrationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{

    public UserRegistrationServiceImpl() {
        System.out.println("UserRegistrationServiceImpl is invoked");
    }
    @Autowired
    UserRegistrationRepositoryImpl repository;

    @Override
    public boolean validateAndSave(UserDto userDto) {
      if(userDto != null);
        return  repository.save(userDto);

    }

    @Override
    public List<UserDto> getAllUsers() {
        return repository.getAllUsers();
    }
}
