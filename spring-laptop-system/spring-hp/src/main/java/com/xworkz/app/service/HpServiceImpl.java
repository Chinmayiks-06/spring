package com.xworkz.app.service;

import com.xworkz.app.dao.HpDao;
import com.xworkz.app.dto.HpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class HpServiceImpl implements HpService{

    @Autowired
    private HpDao dao;

    @Override
    public boolean addUserDetails(HpDto dto) {
        boolean isUserValidated = false;
        boolean isNameValid = false;
        if (dto != null) {
            if (dto.getFirstName() != null && !dto.getLastName().isEmpty()) {
                isNameValid = true;
            }
            if (isNameValid == true)
                isUserValidated = dao.addUserDetails(dto);
        }
        return isUserValidated;
    }

    @Override
    public HpDto getDetailsById(int id) {
        if (id>0){
            return dao.getDetailsById(id);
        }
        return null;
    }

    @Override
    public List<HpDto> getAllUser() {
        return Collections.emptyList();
    }

    @Override
    public boolean deleteUserById(int id) {
        return false;
    }

    @Override
    public void updateUser(HpDto dto) {

    }

    @Override
    public Object[] getNameAndSerialNoByEmail(String email) {
        return dao.getNameAndSerialNoByEmail(email);
    }

    @Override
    public String getSerialNoById(int id) {
        return dao.getSerialNoById(id);
    }

    @Override
    public String getEmailBySerialNo(String serialNo) {
        return dao.getEmailBySerialNo(serialNo);
    }

    @Override
    public String getEmailById(int id) {
        return dao.getEmailById(id);
    }

    @Override
    public String getNameBySerialNo(String serialNo) {
        return dao.getNameBySerialNo(serialNo);
    }

    @Override
    public String getPasswordByEmail(String email) {
        return dao.getPasswordByEmail(email);
    }

    @Override
    public boolean updatePasswordByEmail(String password, String email) {
        return dao.updatePasswordByEmail(password,email);
    }

    @Override
    public boolean deleteUserBySerialNo(String serialNo) {
        return dao.deleteUserBySerialNo(serialNo);
    }

    @Override
    public boolean deleteUserByName(String firstName) {
        return dao.deleteUserByName(firstName);
    }
}
