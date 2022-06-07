package com.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApplication {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Employee employee=new Employee(101,"Krishna");
        PartTimeEmployee partTimeEmployee=new PartTimeEmployee(201,"Vikas",4,250f);
        FullTimeEmployee fullTimeEmployee=new FullTimeEmployee(301,"Tejas",8,20000f,2500f);

        session.save(employee);
        session.save(partTimeEmployee);
        session.save(fullTimeEmployee);

        transaction.commit();
    }
}
