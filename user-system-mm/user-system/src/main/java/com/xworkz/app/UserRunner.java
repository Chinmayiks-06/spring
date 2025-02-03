package com.xworkz.app;

import com.xworkz.app.config.SpringConfiguration;
import com.xworkz.app.dto.UserDto;
import com.xworkz.app.exception.PhoneNumberNotFoundException;
import com.xworkz.app.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class UserRunner {
    public static void main(String[] args)  {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserDto dto=new UserDto();
       /* dto.setUserId(1);*/
        dto.setUserName("chin");
        dto.setPhNo(5645678883l);
        dto.setAddress("hassan");

       /* UserDto dto1=new UserDto();
        dto1.setUserName("sadff");
        dto1.setPhNo(9876538765L);
        dto1.setAddress("beng");*/


       UserService service= applicationContext.getBean(UserService.class);
//     service.validateAndSave(dto);
      //service.validateAndSave(dto1);

   /*  String ref= service.getUserNameById(3);
    System.out.println("The username for the id " + ref);*/


   // Long ref1=service.getPhNoById(12);
     //  System.out.println("The PhNo for the id " + ref1);

    /* String ref2= service.getAddressById(3);
        System.out.println(ref2);*/


         Object[] obj=service.getUserNameAndPhNoById(2 );
        Arrays.asList(obj).forEach(System.out::println);

//        Object[] obj=service.getUserNameAndAddressById(3);
//        Arrays.asList(obj).forEach(System.out::println);

//        Object[] obj=service.getUserNameAndAddressByPhNo(9876538765L);
//        Arrays.asList(obj).forEach(System.out::println);

//        boolean isUpdate= service.updateAddressByPhNo("BTM Layout",9876538765L);
//        System.out.println(isUpdate);

//        boolean isRemoved= service.deleteUserByPhNo(897654327L);
//        System.out.println(isRemoved);


        List<Object[]> ref=service.getUserNameAndAddress();
        ref.forEach(arrayref -> System.out.println(Arrays.toString(arrayref)));
    }

}
