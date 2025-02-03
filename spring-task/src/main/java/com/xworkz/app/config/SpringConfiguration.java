package com.xworkz.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = " com.xworkz.app")
public class SpringConfiguration {

    @Bean
    public String getUserName(){
        return "Shivakumar";
    }

    @Bean
    public  Integer getUserId(){
        return 45456;
    }

    @Bean
    public Boolean getUserStatus(){
        return  true;
    }

    @Bean
    public Character getUserGender(){
        return 'M';
    }

    @Bean
    public Byte getByteValue(){
        return 78;
    }

    @Bean
    public  Double getPrice(){
        return 55999.00;
    }

    @Bean
    public  Float getFloatValue(){
        return 5654F;
    }

    @Bean
    public Short getShortValue(){
        return  443;
    }
    public List<String> getStringList() {
        List<String> list = new ArrayList<String>();
        list.add("RCB");
        list.add("KKR");
        list.add("MI");
        list.add("GT");
        list.add("CSK");
        list.add("SRH");
        list.add("RR");
        list.add("DD");
        return list;
    }

    public List<Integer> getIntegerList(){
        List<Integer> integerList=new ArrayList<Integer>();
        integerList.add(18);
        integerList.add(65);
        integerList.add(45);
        integerList.add(66);
        integerList.add(07);
        integerList.add(87);
        integerList.add(99);
        integerList.add(17);
       return integerList;
    }

}
