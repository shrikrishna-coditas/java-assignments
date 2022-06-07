package com.bean;

public class HelloWorld {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println("Hello ! "+name);
    }
}
