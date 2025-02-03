package com.xworkz.app.dao;

import com.xworkz.app.dto.HpDto;

import java.util.List;

public interface HpDao {
    boolean addUserDetails(HpDto dto);
    HpDto getDetailsById(int id);

    Object[] getNameAndSerialNoByEmail(String email);
    String getSerialNoById(int id);
    String getEmailBySerialNo(String serialNo);
    String getEmailById(int id);
    String getNameBySerialNo(String serialNo);
    String getPasswordByEmail(String email);
    boolean updatePasswordByEmail(String password,String email);
    boolean deleteUserBySerialNo(String serialNo);
    boolean deleteUserByName(String firstName);

}
