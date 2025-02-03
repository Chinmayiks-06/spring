package com.xworkz.app.flight;

import org.springframework.stereotype.Component;

@Component
public class Car {

    public String model;
    public double price;

    public void drive() {
        System.out.println("Driving the car...");
    }
}
