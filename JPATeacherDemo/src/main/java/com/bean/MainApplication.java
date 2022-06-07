package com.bean;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Iterator;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory= Persistence.createEntityManagerFactory("krishna");
        EntityManager entityManager=managerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery=criteriaBuilder.createQuery();
        Root<Teacher> from=criteriaQuery.from(Teacher.class);


        //Selecting all the records
        System.out.println("Select all records from Teacher");
        CriteriaQuery<Object> select=criteriaQuery.select(from);
        TypedQuery<Object> typedQuery=entityManager.createQuery(criteriaQuery);
        List<Object> list=typedQuery.getResultList();
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
           Teacher o=(Teacher) iterator.next();
           System.out.println(o);
        }


        //selecting specific columns in order
        criteriaQuery.multiselect(from.get("tname"),from.get("salary"));
        System.out.println("Descending order");
        CriteriaQuery<Object> desc= criteriaQuery.orderBy(criteriaBuilder.desc(from.get("salary")));
        TypedQuery<Object> typedQuery1=entityManager.createQuery(desc);
        List<Object> list1=typedQuery1.getResultList();

        Iterator iterator1=list1.iterator();
        while(iterator1.hasNext()){
            Object o[]=(Object[]) iterator1.next();
            System.out.println(o[0]+" "+o[1]);
        }

        Query query=entityManager.createQuery("Select MIN(t.salary) from Teacher t");
        Double res=(Double) query.getSingleResult();
        System.out.println("Min salary: "+res);

        Query query1=entityManager.createQuery("Select tid,tname from Teacher where tname Like 'A%'");
        List<Object> list2=query1.getResultList();

        Iterator iterator2=list2.iterator();
        System.out.println("Teacher name like A%");
        while(iterator2.hasNext()){
            Object o[]=(Object[]) iterator2.next();
            System.out.println(o[0]+" "+o[1]);
        }

        Query query2=entityManager.createQuery("Select tname,salary from Teacher where salary between 250000 and 350000");
        List<Object> list3=query2.getResultList();

        Iterator iterator3=list3.iterator();
        System.out.println("Salary between 250000 and 350000");
        while(iterator3.hasNext()){
            Object o[]=(Object[]) iterator3.next();
            System.out.println(o[0]+" "+o[1]);
        }
    }
}
