package com.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FirstLevelCache {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        //Single session it will fetch from cache
        Director director=(Director) session.load(Director.class,101);
        System.out.println(director.getName());

        session.close();

        director=(Director) session.load(Director.class,101);
        System.out.println(director.getName());

        transaction.commit();


        /*
        //Two different sessions
        Session session1=sessionFactory.openSession();
        Transaction transaction1=session1.beginTransaction();
        Director director=(Director) session.load(Director.class,101);
        System.out.println(director.getName());

        director=(Director) session1.load(Director.class,101);
        System.out.println(director.getName());

        transaction.commit();
        transaction1.commit();



        //using evict method
        Director director=(Director) session.load(Director.class,101);
        System.out.println(director.getName());

        session.evict(director);

        director=(Director) session.load(Director.class,101);
        System.out.println(director.getName());

        transaction.commit();

        */
    }
}
