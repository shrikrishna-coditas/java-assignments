package com.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApplication {
    public static void main(String args[]) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Book book = new Book();
        book.setBook_name("Let us C");
        book.setAuthor_name("Kanetkar");
        book.setBook_price(450.5f);

        int i=(int)session.save(book);

        if(i>0){
            transaction.commit();
            System.out.println("Record added successfully");
        }
        else{
            System.out.println("Try again..!");
        }

    }
}
