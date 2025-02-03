package com.xworkz.app.service;

import com.xworkz.app.dto.HpDto;

import java.util.List;

public interface HpService {
    boolean addUserDetails(HpDto dto);
    HpDto getDetailsById(int id);
    List<HpDto> getAllUser();
    boolean deleteUserById(int id);
    void updateUser(HpDto dto);

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
