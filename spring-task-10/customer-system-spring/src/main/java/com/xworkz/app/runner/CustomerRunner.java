package com.xworkz.app.runner;

import com.xworkz.app.config.SpringConfig;
import com.xworkz.app.dto.CustomerDto;
import com.xworkz.app.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class CustomerRunner {


    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        CustomerDto customerDto = new CustomerDto();
        CustomerService customerService = applicationContext.getBean(CustomerService.class);

        customerDto.setCustomerName("shiva");
        customerDto.setEmail("shiva@gmail.com");
        customerDto.setCustomerNo(852);

        customerService.save(customerDto);

  //     validate and save details
        /*customerService.save(customerDto);
        System.out.println(customerDto);
*/
       //get by id;
   /*    CustomerDto customerDto1 = customerService.getUserById(1);
        System.out.println(customerDto1);*/

    /*    //get all details
       List<CustomerDto> Dtos = customerService.getAllDetails(customerDto);
        System.out.println(Dtos);

        //update operation;
        CustomerDto dto = new CustomerDto();
        dto.setCustomerName("baba");
        dto.setEmail("baba@gmail.com");
        dto.setCustomerNo(4876543);

        customerService.updateUserById(2,dto);
        System.out.println("Updated sucessfully...!!");

//        //delete operation;
        customerService.DeleteUserById(9);
       System.out.println("Deleted the row...!!");

        //getNameByNo
        int no = 123;
        String name = customerService.getNameByNo(no);
        System.out.println("name for the given number "+no+" is "+name);

        //getEmailByNo
        no = 123;
        String email = customerService.getEmailByNo(no);
        System.out.println("email for the given number "+no+" is "+email);

        System.out.println("get No And Name By Email");
        Object [] obj = customerService.getNoAndNameByEmail("babi@gmail.com");
        Arrays.stream(obj).forEach(System.out::println);

        boolean updated = customerService.updateNoByName(800,"prema");
        System.out.println("Is updated: "+updated);

        boolean isDeleted = customerService.deleteCustomerByEmail("prema@gmail.com");
        System.out.println("Is deleted: "+isDeleted);*/
    }
}
