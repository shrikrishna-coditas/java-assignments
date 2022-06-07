package com.bean;

import java.util.List;
import java.util.Set;

public class Doctors {
    int doc_id;
    Set<Gynac> gynacSet;
    Set<Pediatric> pediatricSet;
    Set<AnastetiaSpec> anastetiaSpecSet;
    List<Staff> staffList;

    public Doctors(){

    }

    public Doctors(Set<Gynac> gynacSet, Set<Pediatric> pediatricSet, Set<AnastetiaSpec> anastetiaSpecSet, List<Staff> staffList) {
        this.gynacSet = gynacSet;
        this.pediatricSet = pediatricSet;
        this.anastetiaSpecSet = anastetiaSpecSet;
        this.staffList = staffList;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public Set<Gynac> getGynacSet() {
        return gynacSet;
    }

    public void setGynacSet(Set<Gynac> gynacSet) {
        this.gynacSet = gynacSet;
    }

    public Set<Pediatric> getPediatricSet() {
        return pediatricSet;
    }

    public void setPediatricSet(Set<Pediatric> pediatricSet) {
        this.pediatricSet = pediatricSet;
    }

    public Set<AnastetiaSpec> getAnastetiaSpecSet() {
        return anastetiaSpecSet;
    }

    public void setAnastetiaSpecSet(Set<AnastetiaSpec> anastetiaSpecSet) {
        this.anastetiaSpecSet = anastetiaSpecSet;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }
}
