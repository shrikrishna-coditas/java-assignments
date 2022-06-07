package com.bean;

public class Particpants {
    private String name,address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Particpants{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
