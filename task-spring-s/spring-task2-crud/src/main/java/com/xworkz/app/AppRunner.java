package com.xworkz.app;

import com.xworkz.app.config.SpringConfiguration;
import com.xworkz.app.dto.AppDto;
import com.xworkz.app.service.AppService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AppDto appDto=applicationContext.getBean(AppDto.class);
        appDto.setAppName("flipkart");
        appDto.setAppVersion("4.3.28");
        appDto.setReleasedOn("12-5-2022");
        appDto.setFounderName("hyffjhk");
        appDto.setDownloadSize("45 MB");


       AppService appService =applicationContext.getBean(AppService.class);
       appService.validateAndAddApp(appDto);

//        boolean ref =appService.validateAndUpdateAppNameById("Safari",1);
//        System.out.println(ref);

       /* boolean ref=appService.validateAndDeleteApp(6);
        System.out.println(ref);*/

    }
}
