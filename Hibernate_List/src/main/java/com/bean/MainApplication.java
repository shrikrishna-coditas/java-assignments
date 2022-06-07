package com.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Film film=new Film();
        film.setId(101);
        film.setName("Shershaah");

        List<Songs> songsList=new ArrayList<>();

        songsList.add(new Songs(1,"Lambiyan"));
        songsList.add(new Songs(2,"Ranjha"));
        songsList.add(new Songs(3,"Title song"));

        film.setSongs(songsList);

        Film film1=new Film();
        film1.setId(102);
        film1.setName("KGF");

        List<Songs> songsList1=new ArrayList<>();

        songsList1.add(new Songs(4,"Salaam rocky bhai"));
        songsList1.add(new Songs(5,"Garbhadi"));
        songsList1.add(new Songs(6,"Dheera dheera"));

        film1.setSongs(songsList1);

        session.save(film);
        session.save(film1);

        transaction.commit();
    }
}
