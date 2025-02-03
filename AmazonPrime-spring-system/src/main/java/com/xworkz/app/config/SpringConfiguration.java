package com.xworkz.app.config;

import com.xworkz.app.allclass.Book;
import com.xworkz.app.allclass.CurrentBill;
import com.xworkz.app.allclass.Laptop;
import com.xworkz.app.allclass.Metro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(value = "com.xworkz.app")
public class SpringConfiguration {

    @Bean
  public List<String> getAllDetails(){
      List<String> ap=new ArrayList<>();
      ap.add("pushpa");
      ap.add("kgf");
      return ap;
  }
@Bean
  public List<Integer> getBooleanValue(){
        List<Integer> bo=new ArrayList<>();
        bo.add(123);
        bo.add(345);
        bo.add(123);
        return bo;
  }
  @Bean
    public List<String> carModels() {
        List<String> cars = new ArrayList<>();
        cars.add("Toyota");
        cars.add("Honda");
        cars.add("Ford");
        return cars;
    }

    @Bean
    public List<Book> bookNamesList(){
        Book books=new Book("god","alexa",23.99,1993);
        Book books1 = new Book("The Alchemist", "Paulo Coelho", 15.99, 1988);
        Book books2 = new Book("1984", "George Orwell", 12.50, 1949);
        Book books3 = new Book("To Kill a Mockingbird", "Harper Lee", 18.75, 1960);
        Book books4 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 14.95, 1925);
        Book books5 = new Book("Moby Dick", "Herman Melville", 22.30, 1851);
        Book books6 = new Book("Pride and Prejudice", "Jane Austen", 19.99, 1813);
        Book books7 = new Book("The Catcher in the Rye", "J.D. Salinger", 17.49, 1951);
        Book books8 = new Book("War and Peace", "Leo Tolstoy", 25.99, 1869);
        Book books9 = new Book("Crime and Punishment", "Fyodor Dostoevsky", 21.50, 1866);

        List<Book> list=new ArrayList<Book>();
        list.add(books);
        list.add(books1);
        list.add(books2);
        list.add(books3);
        list.add(books4);
        list.add(books5);
        list.add(books6);
        list.add(books7);
        list.add(books8);
        list.add(books9);
        return  list;
    }
 //@Bean(value ="metro")--this value name can be given in getBean method
    @Bean
    public List<Metro> getMetroList() {
     Metro metro = new Metro("green line", "nagsandra", "yelahanka", 4);
     Metro metro1 = new Metro("purple line", "madavara", "national college", 4);
     Metro metro2 = new Metro("green line", "jalalli", "vijaynagara", 4);
     Metro metro3 = new Metro("yellow line", "peenya", "shrirampura", 4);
     Metro metro4 = new Metro("green line", "yashwanthpura", "hassan", 4);
     Metro metro5 = new Metro("green line", "dasralli", "rajajinagar", 4);
     Metro metro6 = new Metro("purple line", "gorguntepalya", "gorguntepalya", 4);
     Metro metro7 = new Metro("green line", "peenya", "peenya", 4);
     Metro metro8 = new Metro("orange line", "jaynagar", "jalalli", 4);
     Metro metro9 = new Metro("green line", "rrnagar", "yashwanthpura", 4);
     List<Metro> listmetro = new ArrayList<Metro>();
     listmetro.add(metro);
     listmetro.add(metro1);
     listmetro.add(metro2);
     listmetro.add(metro3);
     listmetro.add(metro4);
     listmetro.add(metro5);
     listmetro.add(metro6);
     listmetro.add(metro7);
     listmetro.add(metro8);
     listmetro.add(metro9);

     return listmetro;
 }
 @Bean
        public List<CurrentBill> getBillDetails(){
            CurrentBill currentBill=new CurrentBill("Chinmayi",3255664,456.67,769.90,3456.00);
            CurrentBill currentBill1=new CurrentBill("preethi",67890,45656.67,56.487,34565096.00);
            CurrentBill currentBill2=new CurrentBill("shreya",32557894,4756.67,56.495,345806.00);
            CurrentBill currentBill3=new CurrentBill("shiva",32558794,45679.67,56.45,3458976.00);
            CurrentBill currentBill4=new CurrentBill("Channaveer",387809664,47656.67,547.9,367456.00);
            CurrentBill currentBill5=new CurrentBill("lavanya",3255664,45656.67,56.45,34576.00);
            CurrentBill currentBill6=new CurrentBill("manasa",3255664,4576.67,56.45,34568.00);
            CurrentBill currentBill7=new CurrentBill("jeevan",3255664,456756.67,56.45,346756.00);
            CurrentBill currentBill8=new CurrentBill("sowmya",3255664,456870.67,56.45,567.00);
            CurrentBill currentBill9=new CurrentBill("varsha",3255664,456.678,56.45,6785.90);

            List<CurrentBill> currentBillList=new ArrayList<>();
            currentBillList.add(currentBill);
            currentBillList.add(currentBill1);
            currentBillList.add(currentBill2);
            currentBillList.add(currentBill3);
            currentBillList.add(currentBill4);
            currentBillList.add(currentBill5);
            currentBillList.add(currentBill6);
            currentBillList.add(currentBill7);
            currentBillList.add(currentBill8);
            currentBillList.add(currentBill9);
            return currentBillList;
    }

}
