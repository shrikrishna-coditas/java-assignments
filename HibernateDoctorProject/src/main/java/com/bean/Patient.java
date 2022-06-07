package com.bean;

import java.util.Set;

public class Patient {
    private int id;
    private String name;
    Set<MonthlyDetails> monthlyDetailsSet;

    public Patient(int id, String name, Set<MonthlyDetails> monthlyDetailsSet) {
        this.id = id;
        this.name = name;
        this.monthlyDetailsSet = monthlyDetailsSet;
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

    public Set<MonthlyDetails> getMonthlyDetailsSet() {
        return monthlyDetailsSet;
    }

    public void setMonthlyDetailsSet(Set<MonthlyDetails> monthlyDetailsSet) {
        this.monthlyDetailsSet = monthlyDetailsSet;
    }
}
