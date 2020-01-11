package org.o7planning.hellospringmvc.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.o7planning.hellospringmvc.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



public interface BookDAO {
	public Book getBook(int id);
	public List<Book> getBooks();
	public void createBook(Book book);
	public void deleteBook(Book book);
	public void updateBook(Book book);
}

