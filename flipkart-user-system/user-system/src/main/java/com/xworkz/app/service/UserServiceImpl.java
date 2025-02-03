package com.xworkz.app.service;

import com.xworkz.app.dao.UserDao;
import com.xworkz.app.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.NameNotFoundException;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao dao;

    @Override
    public boolean validateAndSave(UserDto dto) {
        boolean isUserNameValid=false;
        boolean isUserValidated=false;
        if(dto!=null){
            if(dto.getUserName()!=null && !dto.getUserName().isEmpty()){
                System.out.println("UserName Validation");
                isUserNameValid=true;
            }
            if(isUserNameValid==true)
                isUserValidated=dao.save(dto);
        }
        return isUserValidated;
    }


    @Override
    public String getNameByID(int id) throws NameNotFoundException {
        String name = null;
        if (id > 0) {
            name = dao.getNameById(id);
        }
        if (name == null) {
            throw new NameNotFoundException("Name not found for ID: " + id);
        }
        return name;
    }

    @Override
    public boolean updateAdressByPhoneNo(String address, long phNo) {

        boolean isUpdated=false;
    String convertedPhNo=String.valueOf(phNo) ;
        if (convertedPhNo.length() ==10)
            isUpdated=dao.editAddressByPhoneNumber(address,phNo) ;

        return isUpdated;
    }

    @Override
    public boolean deleteUserByPhoneNo(long phNo) {

        boolean isdeleted=false;
        String deleteByPhoneNumber=String.valueOf(phNo);
        if (deleteByPhoneNumber.length()==11)
            isdeleted=dao.removeUserByPhoneNumber(phNo);

        return isdeleted;
    }


}
