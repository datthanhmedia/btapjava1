package vn.datthanh.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.datthanh.bo.Order;
import vn.datthanh.dao.OrderDAO;

/**
 * Servlet implementation class OrderOfSalerServlet
 */
@WebServlet(name = "OrderOfSaler", urlPatterns = { "/OrderOfSaler" })
public class OrderOfSalerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderOfSalerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession(false);
		String saler = (String) session.getAttribute("useracc");
		OrderDAO orderdao = new OrderDAO();
		ArrayList<Order> listOrder = orderdao.getOrderBySaler(saler);
		request.setAttribute("listOrder", listOrder);
		RequestDispatcher dispatcher = this.getServletContext().
		getRequestDispatcher("/WEB-INF/views/orderofsaler.jsp");
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
