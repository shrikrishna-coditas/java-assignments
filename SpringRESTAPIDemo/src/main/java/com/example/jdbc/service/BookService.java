package com.example.jdbc.service;

import java.util.List;

import com.example.jdbc.model.Book;

public interface BookService {
	public int insertBook(Book b);
	public int updateBook(String bn,float p);
	public void deleteBook(int bid);
	public List<Book> getAllBooks();
}
