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
//        PatientDto patientDto = applicationContext.getBean(PatientDto.class);
//        patientDto.setPatientName("Bhimashankar");
//        patientDto.setPatientLastname("Talwar");
//        patientDto.setPatientPhoneNo(8787878765L);
//        patientDto.setPatientAddress("Bengaluru");
//        patientDto.setPatientAge(95);

        PatientService patientService=applicationContext.getBean(PatientService.class);
//        patientService.addPatient(patientDto);

//       PatientDto patientById= patientService.getPatientById(9);
//        System.out.println(patientById);

//       boolean ref =patientService.deletePatient(6);
//        System.out.println(ref);

//       String ref =patientService.getPatientNameById(28);
//        System.out.println(ref);

//        Object[] o=patientService.getPatientNameAndPhoneNumberById(1);
//        Arrays.asList(o).forEach(System.out::println);

//        String ref=patientService.getPatientLastNameById(1);
//        System.out.println(ref);

       boolean updateName =patientService.updatePatientNameById("Kirataka",4);
        System.out.println("Name Updated ="+updateName);
    }
}
