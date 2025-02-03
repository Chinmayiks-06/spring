package com.xworkz.app;

import com.xworkz.app.config.SpringConfiguration;
import com.xworkz.app.flight.Car;
import com.xworkz.app.flight.Flight;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class FlightRunner {
    public static void main(String[] args) {
        //spring container
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(SpringConfiguration.class);

        Flight flight=applicationContext.getBean(Flight.class);
        Flight flight1=applicationContext.getBean(Flight.class);
        flight.flightId=1;
        System.out.println(flight.flightName="Chinmayi");
        System.out.println(flight);
        System.out.println(flight1);

        Character springConfiguration=applicationContext.getBean(Character.class);
        System.out.println(springConfiguration);
        Float aFloat=applicationContext.getBean(Float.class);
        System.out.println(aFloat);
        System.out.println(springConfiguration);

        Car car1 = applicationContext.getBean(Car.class);
        Car car2 = applicationContext.getBean(Car.class);

        car1.model = "Tesla";
        car1.price = 80000;
        car1.drive();
        System.out.println(car1);
        System.out.println(car2);

        List<String> cars = applicationContext.getBean("carModels", List.class);
        System.out.println("Available Car Models: " + cars);
    }


}
