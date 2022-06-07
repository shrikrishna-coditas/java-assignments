package com.example.jdbc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jdbc.model.Book;
import com.example.jdbc.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Transactional
	@Override
	public int insertBook(Book b) {
		return bookRepository.insertBook(b);
	}
	
	@Transactional
	@Override
	public int updateBook(String bn, float p) {
		return bookRepository.updateBook(bn, p);
	}
	
	@Transactional
	@Override
	public void deleteBook(int bid) {
		bookRepository.deleteBook(bid);
	}
	
	@Transactional
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.getAllBooks();
	}

}
