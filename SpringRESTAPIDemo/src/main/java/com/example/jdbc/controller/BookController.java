package com.example.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.example.jdbc.model.Book;
import com.example.jdbc.service.BookService;

@RestController
@RequestMapping("/")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	//insert->postMapping
	@PostMapping(path="/save")
	public String saveController(@RequestBody Book b) {
		int i=bookService.insertBook(b);
		if(i>0) {
			return "record added successfully";
		}
		else
			return "Try again";
	}
	//update->PutMapping
	@PutMapping(path="update/{bn}/{p}")
	public String updateController(@PathVariable String bn,@PathVariable int p) {
		bookService.updateBook(bn, p);
		return "Record updated successfully";
	}
	//delete->DeleteMapping
	@DeleteMapping(path="delete/{bid}")
	public String deleteController(@PathVariable int bid) {
		bookService.deleteBook(bid);
		return "Data deleted successfully";
	}
	
	//getAll->GetMapping
	@GetMapping(path="getAllBooks")
	public List<Book> fetchController(){
		return bookService.getAllBooks();
	}
	
}
