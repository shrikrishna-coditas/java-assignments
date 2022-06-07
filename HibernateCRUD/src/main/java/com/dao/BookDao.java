package com.dao;

import com.bean.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
    static Configuration configuration=new Configuration().configure("hibernate.cfg.xml");

    public static int insertBook(Book b){
        Session session=configuration.buildSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        int i=(int) session.save(b);

        if(i>0){
            transaction.commit();
            System.out.println("Record added successfully");
        }
        else{
            System.out.println("Try again");
        }

        return i;
    }

    public static int updateBook(String name,float price){
        Session session=configuration.buildSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Query q=session.createQuery("update Book set BookPrice=:x where BookName=:y");

        q.setParameter("x",price);
        q.setParameter("y",name);

        int i=q.executeUpdate();

        transaction.commit();
        return i;
    }

    public static int deleteBook(String name){
        Session session=configuration.buildSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Query q=session.createQuery("delete Book where BookName=:x");

        q.setParameter("x",name);

        int i=q.executeUpdate();

        transaction.commit();
        return i;
    }

    public static List<Book> fetchBooks(){
        Session session=configuration.buildSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        Query q=session.createQuery("from Book");
        List<Book> b=q.list();
        return b;
    }

    public static List<Book> fetchByRestriction(float p){
        Session session=configuration.buildSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Book.class);
        criteria.add(Restrictions.gt("bPrice",p));
        return criteria.list();
    }

    public static List<Book> fetchByOrder(String order,String pn)
    {
        Session session=configuration.buildSessionFactory().openSession();
        Criteria criteria=session.createCriteria(Book.class);

        if(order.equalsIgnoreCase("asc")){
            criteria.addOrder(Order.asc(pn));
        }
        else if(order.equalsIgnoreCase("desc")){
            criteria.addOrder(Order.desc(pn));
        }
        return criteria.list();
    }

    public static List<String> fetchByProjection(String pn){
        Session session=configuration.buildSessionFactory().openSession();

        Criteria criteria=session.createCriteria(Book.class);
        criteria.setProjection(Projections.property(pn));

        return criteria.list();
    }
}
