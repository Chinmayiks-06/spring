package com.xworkz.app.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class State {
    @Autowired
    public City city;
    @Value(value = "Karnataka")
    public String stateName;

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void getStateName() {
        System.out.println("State Name: " + this.stateName);
    }
}
