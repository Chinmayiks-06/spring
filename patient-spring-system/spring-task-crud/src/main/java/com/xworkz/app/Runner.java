package com.xworkz.app;

import com.xworkz.app.config.SpringConfiguration;
import com.xworkz.app.dto.PatientDto;
import com.xworkz.app.service.PatientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        PatientDto patientDto = applicationContext.getBean(PatientDto.class);
        patientDto.setPatientName("chinmayi");
        patientDto.setPatientLastname("gowda");
        patientDto.setPatientPhoneNo(8567478765L);
        patientDto.setPatientAddress("hassan");
        patientDto.setPatientAge(22);

        PatientService patientService=applicationContext.getBean(PatientService.class);
        patientService.addPatient(patientDto);

//       PatientDto patientById= patientService.getPatientById(9);
//        System.out.println(patientById);

//       boolean ref =patientService.deletePatient(3);
//        System.out.println(ref);

//       String ref =patientService.getPatientNameById(28);
//        System.out.println(ref);

//        Object[] o=patientService.getPatientNameAndPhoneNumberById(1);
//        Arrays.asList(o).forEach(System.out::println);

      /*  String ref=patientService.getPatientLastNameById(65);
        System.out.println(ref);*/
    }
}
