package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "TeacherInfo")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int tid;

    @Column(name = "T_Name")
    private String name;

    @Column(name = "T_Subject")
    private String subject;

    @Column(name = "T_Salary")
    private float salary;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
