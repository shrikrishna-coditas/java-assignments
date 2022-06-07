package com.dao;

import com.bean.Book;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BookDao {
    private HibernateTemplate jt;

    public HibernateTemplate getJt() {
        return jt;
    }

    public void setJt(HibernateTemplate jt) {
        this.jt = jt;
    }
    @Transactional(readOnly = false)
    public int insertBook(Book b){
       return (int)jt.save(b);
    }
    @Transactional(readOnly = false)
    public void updateBook(String bookName,float price){
        String query="update Book set price="+price+" where bookName='"+bookName+"'";
        jt.bulkUpdate(query);
    }
    @Transactional(readOnly = false)
    public void deleteBook(String bookName){
        String query="delete from Book where bookName='"+bookName+"'";
        jt.bulkUpdate(query);
    }
    @Transactional(readOnly = false)
    public List<Book> fetchAllBooks(){
        List<Book> books=jt.loadAll(Book.class);
        return books;
    }

    public List<Book> fetchUsingResultSet(float price){
        String sql="from Book where price>"+price+"";
        List<Book> books=(List<Book>) jt.find(sql);
        return books;
    }

    public List<Book> fetchUsingLike(String like){
        String sql="from Book where authorName LIKE '"+like+"%'";
        List<Book> books=(List<Book>) jt.find(sql);
        return books;
    }

    public List<Book> fetchByPriceRange(float minPrice, float maxPrice){
        String sql="from Book where price between "+minPrice+" and "+maxPrice+"";
        List<Book> books=(List<Book>) jt.find(sql);
        return books;
    }

}

