package com.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("PEMP")
@Table(name = "JTS_PEMP")
@PrimaryKeyJoinColumn(name = "id")
public class PartTimeEmployee extends Employee{
    private int no_of_hours;
    private float sal_per_hour;

    public PartTimeEmployee(int id, String name, int no_of_hours, float sal_per_hour) {
        super(id, name);
        this.no_of_hours = no_of_hours;
        this.sal_per_hour = sal_per_hour;
    }

    public int getNo_of_hours() {
        return no_of_hours;
    }

    public void setNo_of_hours(int no_of_hours) {
        this.no_of_hours = no_of_hours;
    }

    public float getSal_per_hour() {
        return sal_per_hour;
    }

    public void setSal_per_hour(float sal_per_hour) {
        this.sal_per_hour = sal_per_hour;
    }
}
