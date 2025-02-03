package com.xworkz.app.service;

import com.xworkz.app.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    boolean save(CustomerDto customerDto);

    CustomerDto getUserById(int id);

    List<CustomerDto> getAllDetails(CustomerDto customerDto);

    void updateUserById(int id, CustomerDto newUserData);

    boolean DeleteUserById(int id);

    String getNameByNo(int no);

    String getEmailByNo(int no);

    Object [] getNoAndNameByEmail(String email);

    boolean updateNoByName(int no,String name);

    boolean deleteCustomerByEmail(String email);

}
