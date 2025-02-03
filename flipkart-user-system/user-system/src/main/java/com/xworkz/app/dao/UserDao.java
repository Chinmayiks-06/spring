package com.xworkz.app.dao;

import com.xworkz.app.dto.UserDto;

public interface UserDao {
    boolean save(UserDto dto);

    String getNameById(int id);

    Boolean editAddressByPhoneNumber(String address,long phNo);

    boolean removeUserByPhoneNumber(long phNo);

}
