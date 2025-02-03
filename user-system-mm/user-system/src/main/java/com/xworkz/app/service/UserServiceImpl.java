package com.xworkz.app.service;

import com.xworkz.app.dao.UserDao;
import com.xworkz.app.dto.UserDto;
import com.xworkz.app.exception.AddressNotFoundException;
import com.xworkz.app.exception.NameNotFoundException;
import com.xworkz.app.exception.PhoneNumLengthInvalExcep;
import com.xworkz.app.exception.PhoneNumberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

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
    public String getUserNameById(int id) throws NameNotFoundException {
        String userName=null;
            if (id > 0)
                 userName=dao.getUserNameById(id);

                if (userName == null) {
                    throw new NameNotFoundException("name not found");
                }

            return userName;
    }

    @Override
    public Long getPhNoById(int id) throws PhoneNumberNotFoundException, PhoneNumLengthInvalExcep {
        Long p = null;
        String convertedPhNo = String.valueOf(p);
        try {
            if (convertedPhNo.length() > 10 || convertedPhNo.length() < 10){
            //if(convertedPhNo.length()!=10){
                throw new PhoneNumLengthInvalExcep("length is not crct");
            }

            if (id > 0) {
                p = dao.getPhNoById(id);
            }
            if (p == null) {
                throw new PhoneNumberNotFoundException("phone number not found");
            }
        }

        catch (PhoneNumberNotFoundException | PhoneNumLengthInvalExcep e) {
            e.printStackTrace();
        }
        return p;
    }


    @Override
    public String getAddressById(int id) throws AddressNotFoundException {
        String address=null;
        if(id>0)
            address= dao.getAddressById(id);

        if(address==null){
            throw new AddressNotFoundException("Address Not found");
        }
        return address;
    }


    @Override
    public Object[] getUserNameAndPhNoById(int id) {
       Object obj[]=null;
       if(id>0)
           obj= dao.getUserNameAndPhNoById(id);
       return obj;
    }

    @Override
    public Object[] getUserNameAndAddressById(int id) {
        Object obj[]=null;
        if(id>0)
            obj= dao.getUserNameAndAddressById(id);
        return obj;
    }

    @Override
    public Object[] getUserNameAndAddressByPhNo(long phNo) {
        Object[] obj=null;
        String convertedPhNo=String.valueOf(phNo);
        if(convertedPhNo.length()==10)
            obj=dao.getUserNameAndAddressByPhNo(phNo);

        return obj;
    }

    @Override
    public boolean updateAddressByPhNo(String address, long phNo) {
        boolean isAddressUpdated=false;
        String convertedPhNo=String.valueOf(phNo);
        if(address!=null && !address.isEmpty() && convertedPhNo.length()==10)
            isAddressUpdated=dao.editAddressByPhNo(address,phNo);
        return isAddressUpdated;
    }

    @Override
    public boolean deleteUserByPhNo(long phNo) {
        boolean isUserDeleted=false;
        String convertedPhNo=String.valueOf(phNo);
        if(convertedPhNo.length()==9)
            isUserDeleted=dao.removeUserByPhNo(phNo);
        return isUserDeleted;
    }

    @Override
    public List<Object[]> getUserNameAndAddress() {
        return dao.getUserNameAndAddress();
    }
}
