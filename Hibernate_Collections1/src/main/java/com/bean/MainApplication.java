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

        Movie movie=new Movie();
        movie.setId(101);
        movie.setName("The matrix");

        Set<Director> directors=new HashSet<>();
        directors.add(new Director(1,"Lana"));
        directors.add(new Director(2,"Lilly"));

        movie.setDirectors(directors);

        Movie movie1=new Movie();
        movie1.setId(102);
        movie1.setName("Twilight Zone");

        Set<Director> directors1=new HashSet<>();
        directors1.add(new Director(3,"Joe"));
        directors1.add(new Director(4,"John"));
        directors1.add(new Director(5,"George"));

        movie1.setDirectors(directors1);

        session.save(movie);
        session.save(movie1);

        transaction.commit();

    }
}
