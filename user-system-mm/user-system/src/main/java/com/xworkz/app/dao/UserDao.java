package com.xworkz.app.dao;

import com.xworkz.app.dto.UserDto;
import com.xworkz.app.exception.AddressNotFoundException;
import com.xworkz.app.exception.PhoneNumberNotFoundException;

import java.util.List;

public interface UserDao {
    boolean save(UserDto dto);
    String getUserNameById(int id);
    Long getPhNoById(int id) throws PhoneNumberNotFoundException;
    String getAddressById(int id) throws AddressNotFoundException;
    Object[] getUserNameAndPhNoById(int id);
    Object[] getUserNameAndAddressById(int id);
    Object[] getUserNameAndAddressByPhNo(long phNo);
    boolean editAddressByPhNo(String address,long phNo);
    boolean removeUserByPhNo(long phNo);
    List<Object[]> getUserNameAndAddress();
}
