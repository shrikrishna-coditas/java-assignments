package com.dao;

import com.bean.Library;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class LibraryDao {
        static Configuration configuration=new Configuration().configure("hibernate.cfg.xml");

        public static int insertLibrary(Library library){
            Session session= configuration.buildSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            int i=(int) session.save(library);

            if(i>0){
                transaction.commit();
                System.out.println("Record added successfully");
            }
            else{
                System.out.println("Try again");
            }

            return i;
        }

        public static int updateLibrary(String name,int id){
            Session session=configuration.buildSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            Query query=session.createQuery("update library set name=:x where id=:y");

            query.setParameter("x",name);
            query.setParameter("y",id);
            int i=query.executeUpdate();

            transaction.commit();
            return i;
        }

        public static int deleteLibrary(String name){
            Session session=configuration.buildSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            Query q=session.createQuery("delete library where name=:x");

            q.setParameter("x",name);

            int i=q.executeUpdate();

            transaction.commit();
            return i;
        }

        public static List<Library> fetchLibrary(){
            Session session=configuration.buildSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();
            Query q=session.createQuery("from library");
            List<Library> libraries=q.list();
            return libraries;
        }
}
