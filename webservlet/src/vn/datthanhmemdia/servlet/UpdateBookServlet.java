package vn.datthanhmemdia.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.datthanhmedia.bo.Book;
import vn.datthanhmedia.dao.BookDAO;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet(name = "updateBook", urlPatterns = { "/updateBook" })
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookServlet() {
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
		Book book = bookDAO.getBook(id);
		request.setAttribute("book", book);
		
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/updatebook.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String name = (String) request.getParameter("name");
		String author = (String) request.getParameter("author");
		String publisher = (String) request.getParameter("publisher");
		String priceStr = (String) request.getParameter("price");
		int price = Integer.parseInt(priceStr);
		Book updateBook = new Book();
		updateBook.setId(id);
		updateBook.setName(name);
		updateBook.setAuthor(author);
		updateBook.setPublisher(publisher);
		updateBook.setPrice(price);
		BookDAO bookDAO = new BookDAO();
		bookDAO.updateBook(updateBook);
		response.sendRedirect(request.getContextPath() + "/bookList");
	}

}
