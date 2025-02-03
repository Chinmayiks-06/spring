package com.xworkz.app.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Area {

    @Autowired
  public  Street street;
    public String areaName;

}
