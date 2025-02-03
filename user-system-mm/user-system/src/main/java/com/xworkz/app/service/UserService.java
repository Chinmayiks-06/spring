package com.xworkz.app.service;

import com.xworkz.app.dao.UserDao;
import com.xworkz.app.dto.UserDto;
import com.xworkz.app.exception.AddressNotFoundException;
import com.xworkz.app.exception.PhoneNumberNotFoundException;

import java.util.List;

public interface UserService {
    public boolean validateAndSave(UserDto dto);
    String getUserNameById(int id);
    Long getPhNoById(int id) throws PhoneNumberNotFoundException;
    String getAddressById(int id) throws AddressNotFoundException;
    Object[] getUserNameAndPhNoById(int id);
    Object[] getUserNameAndAddressById(int id);
    Object[] getUserNameAndAddressByPhNo(long phNo);
    boolean updateAddressByPhNo(String address, long phNo);
    boolean deleteUserByPhNo(long phNo);
    List<Object[]> getUserNameAndAddress();
}
