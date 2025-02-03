package com.xworkz.app;

import com.xworkz.app.config.SpringConfiguration;
import com.xworkz.app.dto.AppDto;
import com.xworkz.app.service.AppService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class);

        AppDto dto=new AppDto();
        dto.setUserName("chinmayi");
        dto.setEmail("kscghh123@gmail.com");
        dto.setPassword("jhgfghj");
        dto.setConfPassword("jhgfghj");

        AppService appService=applicationContext.getBean(AppService.class);
        appService.validateAndAddUser(dto);





    }
}
