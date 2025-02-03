package com.xworkz.app.allclass;

import org.springframework.stereotype.Component;

@Component
public class CarModels {

    public String model;
    public double price;

    public void drive() {
        System.out.println("Driving the car...");
    }
}
