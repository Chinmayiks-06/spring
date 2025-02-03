package com.xworkz.app.patient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Address {

    @Autowired
    public Country country;
    public void getAddressDetails(Country country){
        if (country != null) {
            System.out.println("Giving country name...");
            this.country = country;
            this.country.getcountryName(country.state);

        } else {
            System.out.println("Can't display error occured");
        }
    }



}
