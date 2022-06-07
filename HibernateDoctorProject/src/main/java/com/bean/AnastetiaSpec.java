package com.bean;

public class AnastetiaSpec {
    private int id;
    private String name;
    private String degree;
    private String full_or_part;
    private String perm_or_sub;

    public AnastetiaSpec(int id, String name, String degree, String full_or_part, String perm_or_sub) {
        this.id = id;
        this.name = name;
        this.degree = degree;
        this.full_or_part = full_or_part;
        this.perm_or_sub = perm_or_sub;
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getFull_or_part() {
        return full_or_part;
    }

    public void setFull_or_part(String full_or_part) {
        this.full_or_part = full_or_part;
    }

    public String getPerm_or_sub() {
        return perm_or_sub;
    }

    public void setPerm_or_sub(String perm_or_sub) {
        this.perm_or_sub = perm_or_sub;
    }
}
