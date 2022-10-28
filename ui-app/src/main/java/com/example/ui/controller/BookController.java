package com.example.ui.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ui.model.Book;
import com.example.ui.repository.BookRepository;
import com.example.ui.service.BookService;

@Controller
public class BookController {

	@Autowired
    private BookService bookService;

	
	  @RequestMapping("/books")
	  public String getBooks(Model model) {
		  List<Book> books = bookService.listOfBooks();
		  model.addAttribute("books", books);
		  return "books"; 
	  }
	  
	  // ModelAndView
	  
	  @RequestMapping("/books/{id}") 
	  public String getBookById(Model model, @PathVariable int id) {
		  Optional<Book> book = bookService.findBookById(id); book.ifPresent(value ->
		  model.addAttribute("book", value)); 
		  return "book"; 
	  }
	 
	  
	  @RequestMapping("/addBook")
	  public String addBook(Model model, Book book) {
		  bookService.addBook(book);
		  
		  List<Book> books = bookService.listOfBooks();
		  model.addAttribute("books", books);
		  
		  return "books";
	  }
}
