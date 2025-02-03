package com.xworkz.app.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Country {

    @Autowired
    public State state;
    public String countryName;

    public void getcountryName(State state) {

        System.out.println("the country name is:" + this.countryName);

    }

}
