package com.xworkz.app.service;


import com.xworkz.app.dao.AppDao;
import com.xworkz.app.dao.AppDaoImpl;
import com.xworkz.app.dto.AppDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppServiceImpl implements AppService {

    @Autowired
  private AppDao appDao;

    public boolean validateAndAddUser(AppDto appDto) {
        boolean isUserValidated = false;
        boolean isUserNameValidated = false;

        if (appDto != null) {
            if (appDto.getUserName() != null && !appDto.getUserName().isEmpty()) {
                isUserNameValidated = true;

                if (isUserNameValidated == true) {
                    isUserValidated = appDao.addUser(appDto);
                }
            }
        }
        return isUserValidated;
    }



    @Override
    public AppDto validateAndGetDetailsByFirstName(String userName) {
        if(userName!=null){
            return  appDao.getDetailsByFirstName(userName);
        }
        return null;
    }

    @Override
    public AppDto validateAndGetDetailsById(int id) {
        if(id>0){
            return  appDao.getDetailsById(id);
        }
        return null;
    }


    @Override
    public List<AppDto> getAllDetails() {
        return appDao.getAllDetails();
    }

    @Override
    public boolean validateAndDeleteUserById(int id) {
        System.out.println("Service Validate and Delete Started");
        if(id > 0){
           return appDao.deleteUserById(id);
        }
        System.out.println("Service Validate and Delete Ended");
        return false;
    }

    @Override
    public boolean updateUser(AppDto appDto) {
        boolean isUserUpdated=false;
        if(appDto!=null){
            return appDao.updateUser(appDto);

        }
      return isUserUpdated;
    }





}
