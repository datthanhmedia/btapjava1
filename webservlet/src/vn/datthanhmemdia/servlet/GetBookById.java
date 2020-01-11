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
 * Servlet implementation class GetBookById
 */
@WebServlet(name = "getBook", urlPatterns = { "/getBook" })
public class GetBookById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public GetBookById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/searchbyid.jsp");
				dispatcher.forward(request, response);
			
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = (String) request.getParameter("bookid");
		int id = Integer.parseInt(idStr);
		BookDAO bookDAO = new BookDAO();
		Book listBook = bookDAO.getBook(id);
		request.setAttribute("bookList", listBook);
		RequestDispatcher dispatcher1 =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/booklist.jsp");
				dispatcher1.forward(request, response);
		
	}

}
