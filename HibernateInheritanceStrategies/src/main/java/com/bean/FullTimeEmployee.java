package com.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "JTS_FEMP")
//@DiscriminatorValue("FEMP")
@PrimaryKeyJoinColumn(name = "id")
public class FullTimeEmployee extends Employee{
    private int extra_hours;
    private float fix_salary,extra_salary;

    public FullTimeEmployee(int id, String name, int extra_hours, float fix_salary, float extra_salary) {
        super(id, name);
        this.extra_hours = extra_hours;
        this.fix_salary = fix_salary;
        this.extra_salary = extra_salary;
    }

    public int getExtra_hours() {
        return extra_hours;
    }

    public void setExtra_hours(int extra_hours) {
        this.extra_hours = extra_hours;
    }

    public float getFix_salary() {
        return fix_salary;
    }

    public void setFix_salary(float fix_salary) {
        this.fix_salary = fix_salary;
    }

    public float getExtra_salary() {
        return extra_salary;
    }

    public void setExtra_salary(float extra_salary) {
        this.extra_salary = extra_salary;
    }
}
