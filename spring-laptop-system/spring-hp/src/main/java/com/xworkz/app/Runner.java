package com.xworkz.app;

import com.xworkz.app.config.SpringConfiguration;
import com.xworkz.app.dto.HpDto;
import com.xworkz.app.service.HpService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        HpDto dto = new HpDto();

        dto.setFirstName("Shreya");
        dto.setLastName("B Kulal");
        dto.setSerialNumber("HP95ENHG");
        dto.setEmail("shreya@gmail.com");
        dto.setPassword("345fgiuj");

        HpService service = applicationContext.getBean(HpService.class);

       // service.addUserDetails(dto);

        Object[] obj =service.getNameAndSerialNoByEmail("shreya@gmail.com");
        Arrays.asList(obj).forEach(System.out::println);

        String sl = service.getSerialNoById(2);
        System.out.println("Serial number is : "+sl);


        boolean isUpdate=service.updatePasswordByEmail("aqaqa","shreya@gmail.com");
        System.out.println("Updated : "+isUpdate);



    }
}
