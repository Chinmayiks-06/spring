package com.xworkz.app;

import com.xworkz.app.config.SpringConfiguration;
import com.xworkz.app.patient.Patient;
import com.xworkz.app.patient.State;
import com.xworkz.app.patient.Street;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRunner {

    public static void main(String[] args) {

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class);

        Patient patient=applicationContext.getBean(Patient.class);

        Street street=patient.address.country.state.city.area.street;

        System.out.println("Street number is: "+street.streetNo);
        System.out.println("Street number is: "+street.streetName);

        State state=patient.address.country.state;
        System.out.println("State name is: "+state.stateName);
    }
}
