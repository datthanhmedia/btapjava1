package vn.datthanhmemdia.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.datthanhmedia.bo.Book;
import vn.datthanhmedia.dao.BookDAO;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet(name = "bookList", urlPatterns = { "/bookList" })
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get data from database Mysql
		BookDAO bookDAO = new BookDAO();
		ArrayList<Book> bookList = bookDAO.getAllBook();
		
		//Forward to book list view	
		request.setAttribute("bookList", bookList);
		RequestDispatcher dispatcher = this.getServletContext().
		getRequestDispatcher("/WEB-INF/views/booklist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
