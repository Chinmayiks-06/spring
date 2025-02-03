package com.xworkz.app.flight;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//meta-information
@Component
//@Scope(value = "prototype")
public class Flight {

    public int flightId;
    public  String flightName;
    public double cost;


    public  void travel(){
        System.out.println("travelling above the ground level");
    }
}
