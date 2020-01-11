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
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet(name = "deleteBook", urlPatterns = { "/deleteBook" })
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBook = (String) request.getParameter("id");
		int id = Integer.parseInt(idBook);
		BookDAO bookDAO = new BookDAO();
		bookDAO.deleteBook(id);
		ArrayList<Book> bookList = bookDAO.getAllBook();
		request.setAttribute("bookList", bookList);
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/booklist.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
