package com.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApplication {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Teacher teacher=new Teacher();
        teacher.setName("Virat");
        teacher.setSubject("Sports");
        teacher.setSalary(11000f);

        int i=(int)session.save(teacher);

        if(i>0){
            transaction.commit();
            System.out.println("Record added successfully");
        }
        else{
            System.out.println("Try again..!");
        }

    }
}
