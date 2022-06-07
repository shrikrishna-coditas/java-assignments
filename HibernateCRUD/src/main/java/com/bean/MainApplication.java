package com.bean;

import com.dao.BookDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int ch,i;
        String bn,an,pn;
        float p;
        Book b;
        List<Book> books;

        do{
            System.out.println("1.Insert\n2.Update\n3.Delete\n4.Fetch\n5.Fetch by Restriction\n"+
                    "6.Fetch by order\n7.Fetch by projection\n8.Exit\n");
            System.out.println("Enter your choice");
            ch=Integer.parseInt(br.readLine());

            switch (ch){
                case 1:
                    System.out.println("Enter Book name,Author name,Book price");
                    b=new Book();
                    b.setbName(br.readLine());
                    b.setbAuthor(br.readLine());
                    b.setbPrice(Float.parseFloat(br.readLine()));
                    i=BookDao.insertBook(b);
                    System.out.println(i+" rows inserted");
                    break;
                case 2:
                    System.out.println("Enter Book name,Book price");
                    bn=br.readLine();
                    p=Float.parseFloat(br.readLine());
                    i=BookDao.updateBook(bn,p);
                    System.out.println(i+" rows updated");
                    break;
                case 3:
                    System.out.println("Enter book name");
                    bn=br.readLine();
                    i=BookDao.deleteBook(bn);
                    System.out.println(i+" rows deleted");
                    break;
                case 4:
                    books=BookDao.fetchBooks();
                    for (Book book: books)
                    {
                        System.out.println(book);
                    }
                    break;
                case 5:
                    System.out.println("Enter the price");
                    p=Float.parseFloat(br.readLine());
                    books=BookDao.fetchByRestriction(p);
                    for (Book book:books) {
                        System.out.println(book);
                    }
                    break;
                case 6:
                    System.out.println("Enter the order and property name");
                    String order= br.readLine();
                    pn= br.readLine();
                    books=BookDao.fetchByOrder(order,pn);
                    for (Book book:books){
                        System.out.println(book);
                    }
                    break;
                case 7:
                    System.out.println("Enter property name");
                    pn= br.readLine();
                    List<String> list=BookDao.fetchByProjection(pn);
                    for (String item:list) {
                        System.out.println(item);
                    }
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }while(true);
    }
}
