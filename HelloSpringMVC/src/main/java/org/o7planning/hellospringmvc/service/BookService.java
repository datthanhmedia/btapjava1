package org.o7planning.hellospringmvc.service;

import java.util.List;

import org.o7planning.hellospringmvc.model.Book;



public interface BookService {
	public List<Book> getBooks();
	public Book getBook(int id);
	public void createBook(Book book);
	public void deleteBook(int id);
	public void updateBook(Book book);
}