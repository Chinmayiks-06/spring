package com.xworkz.app.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Street {


  @Value(value = "Rajajinagar")
  public String streetName;

  @Value(value = "123")
  public  int streetNo;
}
