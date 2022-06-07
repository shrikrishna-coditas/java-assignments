package com.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class MainApplication {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Director director=new Director();
        director.setId(101);
        director.setName("Yash Chopra");

        Set<Movie> movies=new HashSet<>();
        movies.add(new Movie(1,"DDLJ"));
        movies.add(new Movie(2,"Mohobatein"));
        movies.add(new Movie(3,"Dhoom"));
        movies.add(new Movie(4,"Kala Pathar"));

        director.setMovies(movies);

        Director director1=new Director();
        director1.setId(102);
        director1.setName("Subhash Ghai");

        Set<Movie> movies1=new HashSet<>();
        movies1.add(new Movie(5,"Ram Lakhan"));
        movies1.add(new Movie(6,"Taal"));
        movies1.add(new Movie(7,"Mr.India"));
        movies1.add(new Movie(8,"Gadar"));
        movies1.add(new Movie(9,"Yadein"));

        director1.setMovies(movies1);

        session.save(director);
        session.save(director1);

        transaction.commit();


    }
}
