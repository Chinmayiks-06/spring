package com.xworkz.app.book;

import org.springframework.stereotype.Component;

@Component
public class Book {
    public String title;
    public String author;
    public double price;
    public int publicationYear;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
