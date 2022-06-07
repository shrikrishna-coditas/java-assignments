package com.bean;

public class MonthlyDetails {
    private int monthNo;
    private String baby_stage;
    private String exp_due;
    private int bp;
    private int sugar;
    private float weight;

    public MonthlyDetails(int monthNo, String baby_stage, String exp_due, int bp, int sugar, float weight) {
        this.monthNo = monthNo;
        this.baby_stage = baby_stage;
        this.exp_due = exp_due;
        this.bp = bp;
        this.sugar = sugar;
        this.weight = weight;
    }

    public int getMonthNo() {
        return monthNo;
    }

    public void setMonthNo(int monthNo) {
        this.monthNo = monthNo;
    }

    public String getBaby_stage() {
        return baby_stage;
    }

    public void setBaby_stage(String baby_stage) {
        this.baby_stage = baby_stage;
    }

    public String getExp_due() {
        return exp_due;
    }

    public void setExp_due(String exp_due) {
        this.exp_due = exp_due;
    }

    public int getBp() {
        return bp;
    }

    public void setBp(int bp) {
        this.bp = bp;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
