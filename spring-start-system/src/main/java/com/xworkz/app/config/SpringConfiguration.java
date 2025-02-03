package com.xworkz.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.xworkz.app")
public class SpringConfiguration {

    public SpringConfiguration() {

    }

    @Bean
    public Boolean getUserStatus() {
        return true;
    }

    @Bean
    public Integer getNumberOfpassengers() {
        return 24;
    }
    @Bean
    public  Short getShortValue(){
        return 26000;
    }
    @Bean
    public Byte getBytevalue(){
        return 67;
    }
    @Bean
    public Long getLongValue(){
        return 67890987654L;
    }
    @Bean
    public Float getFloatValue() {
        return 22.23F;
    }
    @Bean
    public  Double getDoubleValue(){
  return 23.889D;
    }
    @Bean
    public  Character getCharacterValue(){
        return 'c';
    }
    @Bean
    public List<String> amusementParkNames(){
      List<String> s=new ArrayList<>();
      s.add("GRS");
      s.add("wonder la");
      s.add("fun world");
      return s;
   }
    public List<String> carModels() {
        List<String> cars = new ArrayList<>();
        cars.add("Toyota");
        cars.add("Honda");
        cars.add("Ford");
        return cars;
    }

}

