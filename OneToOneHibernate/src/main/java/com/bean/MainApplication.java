package com.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApplication {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Director director=new Director();
        director.setId(101);
        director.setName("Yash Chopra");

        Movie movie=new Movie(1,"DDLJ");

        director.setMovie(movie);

        session.save(director);

        transaction.commit();
    }
}
