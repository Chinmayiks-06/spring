package com.xworkz.app;

import com.xworkz.app.book.Bicycle;
import com.xworkz.app.config.SpringConfiguration;
import com.xworkz.app.book.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class);






    }
}
