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
        appDto.setAppName("IRCTC");
        appDto.setAppVersion("4.2.28");
        appDto.setReleasedOn("27 Sept 1999");
        appDto.setFounderName("Dalhousie");
        appDto.setDownloadSize("199.04 MB");


       AppService appService =applicationContext.getBean(AppService.class);
//        appService.validateAndAddApp(appDto);

//        boolean ref =appService.validateAndUpdateAppNameById("Safari",1);
//        System.out.println(ref);

        boolean ref=appService.validateAndDeleteApp(6);
        System.out.println(ref);

    }
}
