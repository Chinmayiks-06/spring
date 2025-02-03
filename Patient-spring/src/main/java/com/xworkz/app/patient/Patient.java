package com.xworkz.app.patient;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Patient {
    @Autowired
    public Address address;

    public void getpatientDetails(Address address){
        if (address != null) {
            System.out.println("Giving address...");
            this.address = address;
            this.address.getAddressDetails(address.country);

        } else {
            System.out.println("Can't display error occured");
        }
    }

    }





