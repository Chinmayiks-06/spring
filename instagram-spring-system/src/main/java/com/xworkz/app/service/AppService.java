package com.xworkz.app.service;



import com.xworkz.app.dto.AppDto;

import java.util.List;

public interface AppService {
    boolean validateAndAddUser(AppDto appDto);
    AppDto validateAndGetDetailsByFirstName(String userName);

      AppDto validateAndGetDetailsById(int id);
     List<AppDto> getAllDetails();
    boolean validateAndDeleteUserById(int id);
    boolean updateUser(AppDto appDto);


    boolean updateUserNameAndUserEmail
}
