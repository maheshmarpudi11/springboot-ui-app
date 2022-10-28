package com.example.ui.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.ui.model.Book;

@Repository
public class BookRepository {

	
	static Map<Integer,Book> books = new HashMap<>();
	
	static {
		books = new HashMap<>();
		books.put(01, new Book(01,"java", "James Gosling"));
		books.put(02, new Book(02,".net", "	Microsoft"));
		books.put(03, new Book(03,"php", "Rasmus Lerdorf"));	
	}
	
	public List<Book> findAll() {
		
		List<Book> list = new ArrayList<>();
		 for(Integer key :books.keySet()) {
			 list.add(books.get(key));
		 }
		
		return list;
	}

	public Optional<Book> findById(int id) {
		return Optional.of(books.get(id));
	}

	public void save(Book book) {
		books.put(book.getId(), book);
	}

}
