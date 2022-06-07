package com.dao;

import com.bean.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDao {
    private JdbcTemplate jt;

    public JdbcTemplate getJt() {
        return jt;
    }

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    public int insertBook(Book b){
//        String sql="insert into JTBookDetails values(?,?,?,?)";
//        Object[] values={null,b.getBookName(),b.getAuthorName(),b.getPrice()};
//        System.out.println("New book record added");
//        return jt.update(sql,values);
        String query="insert into JTBookDetails(bookName,authorName,price) values (:bookName,:authorName,:price)";
        Map<String,Object> namedParameters=new HashMap<>();
        //namedParameters.put("bid",null);
        namedParameters.put("bookName",b.getBookName());
        namedParameters.put("authorName",b.getAuthorName());
        namedParameters.put("price",b.getPrice());
        NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(jt.getDataSource());
        int status=namedParameterJdbcTemplate.update(query,namedParameters);
        return status;
    }

    public int updateBook(String bookName,float price){
        String query="update JTBookDetails set price='"+price+"'where bookName='"+bookName+"'";

        return jt.update(query);
    }

    public int deleteBook(String bookName){
        String query="delete from JTBookDetails where bookName='"+bookName+"'";
        return jt.update(query);
    }

    public List<Book> fetchAllBooks(){
        String sql="select * from JTBookDetails";
        List<Book> books=jt.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book book=new Book();
                book.setBid(resultSet.getInt(1));
                book.setBookName(resultSet.getString(2));
                book.setAuthorName(resultSet.getString(3));
                book.setPrice(resultSet.getFloat(4));
                return book;
            }
        });
        return books;
    }

    public List<Book> fetchUsingResultSet(float price){
        String sql="select * from JTBookDetails where price>?";
        Object[] values={price};
        List<Book> books=(List<Book>) jt.query(sql, values, new ResultSetExtractor<Object>() {
            @Override
            public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Book> bookList=new ArrayList<>();
                while (resultSet.next()){
                    Book book=new Book();
                    book.setBid(resultSet.getInt(1));
                    book.setBookName(resultSet.getString(2));
                    book.setAuthorName(resultSet.getString(3));
                    book.setPrice(resultSet.getFloat(4));
                    bookList.add(book);
                }
                return bookList;
            }
        });
        return books;
    }

    public List<Book> fetchUsingLike(String like){
        String sql="select * from JTBookDetails where authorName LIKE '"+like+"%'";
        List<Book> books=jt.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book book=new Book();
                book.setBid(resultSet.getInt(1));
                book.setBookName(resultSet.getString(2));
                book.setAuthorName(resultSet.getString(3));
                book.setPrice(resultSet.getFloat(4));
                return book;
            }
        });
        return books;
    }

    public List<Book> fetchByPriceRange(float minPrice, float maxPrice){
        String sql="select * from JTBookDetails where price between "+minPrice+" and "+maxPrice+"";
        List<Book> books=jt.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book book=new Book();
                book.setBid(resultSet.getInt(1));
                book.setBookName(resultSet.getString(2));
                book.setAuthorName(resultSet.getString(3));
                book.setPrice(resultSet.getFloat(4));
                return book;
            }
        });
        return books;
    }

}

