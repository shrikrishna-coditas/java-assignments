package com.bean;


import javax.persistence.*;

@Entity
@Table(name = "BookInfo")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bId;

    @Column(name = "BookName")
    private String bName;

    @Column(name = "AuthorName")
    private String bAuthor;

    @Column(name = "BookPrice")
    private float bPrice;

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public float getbPrice() {
        return bPrice;
    }

    public void setbPrice(float bPrice) {
        this.bPrice = bPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bId=" + bId +
                ", bName='" + bName + '\'' +
                ", bAuthor='" + bAuthor + '\'' +
                ", bPrice=" + bPrice +
                '}';
    }
}
