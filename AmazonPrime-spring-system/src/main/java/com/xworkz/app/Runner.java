package com.xworkz.app;

import com.xworkz.app.allclass.*;
import com.xworkz.app.config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class);

        AmazonPrime amazonPrime=applicationContext.getBean(AmazonPrime.class);
        amazonPrime.primeId=1;

        List list=applicationContext.getBean("getAllDetails",List.class);
        System.out.println(list);

        List list1=applicationContext.getBean("getBooleanValue",List.class);
        System.out.println(list1);



        List<String> cars = applicationContext.getBean("carModels", List.class);
        System.out.println("Available Car Models: " + cars);


        List<Book> list2=applicationContext.getBean("bookNamesList",List.class);
        System.out.println(list2);

        List<Metro> metros=applicationContext.getBean("getMetroList",List.class);
        System.out.println(metros);

        List<CurrentBill> currentBills=applicationContext.getBean("getBillDetails",List.class);
        System.out.println(currentBills);

    }


}
