package com.xworkz.app.service;

import com.xworkz.app.dao.UserDao;
import com.xworkz.app.dto.UserDto;

import javax.naming.NameNotFoundException;

public interface UserService {
    public boolean validateAndSave(UserDto dto);

    public  String getNameByID(int id) throws NameNotFoundException;



    boolean updateAdressByPhoneNo(String address,long phNo);

    boolean deleteUserByPhoneNo(long phNo);
}
