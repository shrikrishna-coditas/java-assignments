package com.bean;

import com.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("SpringJT.xml");
        BookDao d=(BookDao) applicationContext.getBean("bdao");
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String name,author;
        float price;
        do {
            System.out.println("1.Insert\n2.Update\n3.Delete\n4.Fetch all\n5.Fetch by price\n6.Fetch by like\n7.Fetch by price range\n8.Exit");
            int ch=Integer.parseInt(reader.readLine());
            switch (ch){
                case 1:
                    System.out.println("Enter book name,author name & book price");
                    name=reader.readLine();
                    author=reader.readLine();
                    price=Float.parseFloat(reader.readLine());
                    Book book=new Book();
                    book.setBookName(name);
                    book.setAuthorName(author);
                    book.setPrice(price);
                    d.insertBook(book);
                    break;
                case 2:
                    System.out.println("Enter book name of book and price");
                    name=reader.readLine();
                    price=Float.parseFloat(reader.readLine());
                    d.updateBook(name,price);
                    System.out.println("Book updated");
                    break;
                case 3:
                    System.out.println("Enter book name");
                    name=reader.readLine();
                    d.deleteBook(name);
                    System.out.println("Book deleted");
                    break;
                case 4:
                    List<Book> books=d.fetchAllBooks();
                    for(Book book1:books){
                        System.out.println(book1);
                    }
                    break;
                case 5:
                    System.out.println("Enter the price");
                    price=Float.parseFloat(reader.readLine());
                    List<Book> books1=d.fetchUsingResultSet(price);
                    for(Book book1:books1){
                        System.out.println(book1);
                    }
                    break;
                case 6:
                    System.out.println("Enter author name like?");
                    name= reader.readLine();
                    List<Book> books2=d.fetchUsingLike(name);
                    for(Book book1:books2){
                        System.out.println(book1);
                    }
                    break;
                case 7:
                    System.out.println("Enter min and max price range");
                    float minPrice=Float.parseFloat(reader.readLine());
                    float maxPrice=Float.parseFloat(reader.readLine());
                    List<Book> books3=d.fetchByPriceRange(minPrice,maxPrice);
                    for(Book book1:books3){
                        System.out.println(book1);
                    }
                    break;
                case 8:System.exit(0);
                    break;
            }
        }while (true);


    }
}
