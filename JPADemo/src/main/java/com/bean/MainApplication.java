package com.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainApplication {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory= Persistence.createEntityManagerFactory("krishna");
        EntityManager entityManager=managerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        /*
        Student student=new Student();
        student.setName("Krishna");
        student.setCity("Dharwad");

        entityManager.persist(student);
        System.out.println(student);

         */

        Student student=entityManager.find(Student.class,3);
        System.out.println(student);

        entityManager.getTransaction().commit();
    }
}
