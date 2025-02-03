package com.xworkz.app;

import com.xworkz.app.config.SpringConfiguration;
import com.xworkz.app.dto.UserDto;
import com.xworkz.app.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.naming.NameNotFoundException;

public class UserRunner {
    public static void main(String[] args) throws NameNotFoundException {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class);
       /* UserDto dto=new UserDto();
        dto.setUserId(1);
     dto.setUserName("Andy");
        dto.setPhNo(897654327L);
        dto.setAddress("Bengaluru");*/

        UserDto dto1=new UserDto();
        dto1.setUserName("chikk");
        dto1.setPhNo(4567896767L);
        dto1.setAddress("hassan");

        UserDto dto2=new UserDto();
        dto1.setUserName("pree");
        dto1.setPhNo(1234567890L);
        dto1.setAddress("shivmogga");


       UserService service= applicationContext.getBean(UserService.class);
//       service.validateAndSave(dto);
       service.validateAndSave(dto1);
       service.validateAndSave(dto2);

          /*String name =service.getNameByID(100);
        System.out.println("the name is"+name);*/

    /* boolean isUpdated= service.updateAdressByPhoneNo("rajajinagar",9876538765L);
        System.out.println(isUpdated);*/

     /*boolean isdeleted=   service.deleteUserByPhoneNo(45678967678L);
        System.out.println(isdeleted);*/

    }
}
