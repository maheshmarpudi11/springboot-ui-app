package com.example.ui.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ui.model.Book;
import com.example.ui.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public List<Book> listOfBooks() {
		return bookRepository.findAll();
	}

	public Optional<Book> findBookById(int id) {
		return bookRepository.findById(id);
	}

	public void addBook(Book book) {
		
		bookRepository.save(book);
	}
	
	
}
