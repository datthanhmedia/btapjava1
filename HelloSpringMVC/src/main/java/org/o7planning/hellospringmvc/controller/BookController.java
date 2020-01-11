package org.o7planning.hellospringmvc.controller;

import java.util.List;

import org.o7planning.hellospringmvc.model.Book;
import org.o7planning.hellospringmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public String hello(Model model) {
		List<Book> bookList = bookService.getBooks();
		model.addAttribute("bookList", bookList);
		return "booklist";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createBook(Model model) {
		model.addAttribute("book",new Book());
		return "createbook";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createBookAction(@ModelAttribute("book") Book book) {
		bookService.createBook(book);
		return "redirect:getall";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteBook(@RequestParam("id") int id) {
		bookService.deleteBook(id);
		return "redirect:getall";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateBook(Model model, @RequestParam("id") int id) {
		Book book = bookService.getBook(id);
		model.addAttribute("book", book);
		return "updatebook";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateBookAction(@ModelAttribute("book") Book book) {
		bookService.updateBook(book);
		return "redirect:getall";
	}
}