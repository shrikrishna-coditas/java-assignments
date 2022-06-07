package com.bean;

public class Staff {
    private int staff_id;
    private String staff_name;
    private String staff_type;
    private long staff_contact;

    public Staff(int staff_id, String staff_name, String staff_type, long staff_contact) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.staff_type = staff_type;
        this.staff_contact = staff_contact;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_type() {
        return staff_type;
    }

    public void setStaff_type(String staff_type) {
        this.staff_type = staff_type;
    }

    public long getStaff_contact() {
        return staff_contact;
    }

    public void setStaff_contact(long staff_contact) {
        this.staff_contact = staff_contact;
    }
}
