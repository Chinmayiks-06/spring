package com.xworkz.app;

import com.xworkz.app.patient.*;

public class PatientRunner {

        public static void main(String[] args) {


            Address address=new Address();
            address.getAddressDetails(address.country);

            Patient patient=new Patient();


            Country country = new Country();
            country.countryName = "India";
            country.getcountryName(country.state);

            State state=new State();
            state.stateName="Karnataka";
            state.getStateName();

            City city=new City();
            city.cityName="hassan";
           // System.out.println(city);

            Area area=new Area();
            area.areaName="vidyuth nagara";


        }
    }