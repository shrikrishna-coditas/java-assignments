package com.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainApplication {

    public static void updateEntity(int id,String name){
        EntityManagerFactory managerFactory= Persistence.createEntityManagerFactory("krishna");
        EntityManager entityManager=managerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Teacher teacher=entityManager.find(Teacher.class,id);

        teacher.setTname(name);
        entityManager.getTransaction().commit();
    }

    public static void removeEntity(int id){
        EntityManagerFactory managerFactory= Persistence.createEntityManagerFactory("krishna");
        EntityManager entityManager=managerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Teacher teacher=entityManager.find(Teacher.class,id);
        entityManager.remove(teacher);
        entityManager.getTransaction().commit();
    }
    public static void main(String[] args) {
        updateEntity(3,"Shrikrishna");
        removeEntity(3);
    }
}
