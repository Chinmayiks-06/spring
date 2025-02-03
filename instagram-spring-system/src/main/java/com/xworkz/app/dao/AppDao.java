package com.xworkz.app.dao;


import com.xworkz.app.dto.AppDto;

import java.util.List;

public interface AppDao {
    boolean addUser(AppDto appDto);
    AppDto getDetailsByFirstName(String userName);

     AppDto getDetailsById(int id);

        List<AppDto> getAllDetails();

        boolean deleteUserById(int id);
        boolean updateUser(AppDto appDto);



}

