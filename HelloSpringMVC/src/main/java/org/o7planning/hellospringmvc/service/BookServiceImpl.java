package org.o7planning.hellospringmvc.service;

import java.util.List;

import org.o7planning.hellospringmvc.dao.BookDAO;
import org.o7planning.hellospringmvc.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;
	
	public List<Book> getBooks() {
		return bookDAO.getBooks();
	}
	
	public Book getBook(int id) {
		return bookDAO.getBook(id);
	}
	
	public void createBook(Book book) {
		bookDAO.createBook(book);
	}
	
	public void deleteBook(int id) {
		Book book = bookDAO.getBook(id);
		if (book != null) {
			bookDAO.deleteBook(book);
		} 	
		
	}
	
	public void updateBook(Book book) {
		bookDAO.updateBook(book);
	}
}