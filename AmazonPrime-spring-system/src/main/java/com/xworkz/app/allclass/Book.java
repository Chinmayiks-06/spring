package com.xworkz.app.allclass;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component(value = "book")
public class Book {
    public String title;
    public String author;
    public double price;
    public int publicationYear;



}
