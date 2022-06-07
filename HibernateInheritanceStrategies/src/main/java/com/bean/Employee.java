package com.bean;

import javax.persistence.*;

@Entity
@Table(name = "JTS_EMP")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "IDENTIFIER",discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue("EMP")

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
    @Id
    private int id;

    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
