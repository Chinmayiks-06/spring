package com.xworkz.app.service;

import com.xworkz.app.dao.CustomerDao;
import com.xworkz.app.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    boolean isvalidated = false;
    @Override
    public boolean save(CustomerDto customerDto) {
        if(customerDto !=null){
            if(customerDto.getCustomerName() != null && !customerDto.getCustomerName().isEmpty()) {
                System.out.println("Name validated");
                customerDao.save(customerDto);
                isvalidated = true;
            }
        }
        return isvalidated;
    }



    @Override
    public CustomerDto getUserById(int id) {
     return customerDao.getUserById(id);
    }

    @Override
    public List<CustomerDto> getAllDetails(CustomerDto customerDto) {
        return customerDao.getAllDetails(customerDto);
    }

    @Override
    public void updateUserById(int id, CustomerDto newUserData) {
          customerDao.updateUserById(id,newUserData);
    }

    @Override
    public boolean DeleteUserById(int id) {
        return customerDao.DeleteUserById(id);
    }

    @Override
    public String getNameByNo(int no) {
        return customerDao.getNameByNo(no);
    }

    @Override
    public String getEmailByNo(int no) {
        return customerDao.getEmailByNo(no);
    }

    @Override
    public Object[] getNoAndNameByEmail(String email) {
        Object [] obj = customerDao.getNoAndNameByEmail(email);
        return obj;
    }

    @Override
    public boolean updateNoByName(int no, String name) {
        return customerDao.updateNoByName(no,name);
    }

    @Override
    public boolean deleteCustomerByEmail(String email) {
        return customerDao.deleteCustomerByEmail(email);
    }
}
