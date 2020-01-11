package vn.datthanh.servlet;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.datthanh.bo.Order;
import vn.datthanh.dao.OrderDAO;

/**
 * Servlet implementation class DeleteOrderServlet
 */
@WebServlet(name = "DeleteOrder", urlPatterns = { "/DeleteOrder" })
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idOrder = (String) request.getParameter("id");
		int id = Integer.parseInt(idOrder);
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.deleteOrder(id);;
		ArrayList<Order> listOrder = orderDAO.getAllOrder();
		request.setAttribute("listOrder", listOrder);
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/listorder.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
