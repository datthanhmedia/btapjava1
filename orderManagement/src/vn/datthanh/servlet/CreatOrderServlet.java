package vn.datthanh.servlet;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class CreatOrderServlet
 */
@WebServlet(name = "CreatOrder", urlPatterns = { "/CreatOrder" })
public class CreatOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/creatneworder.jsp");
				dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 	
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession(false);
		String saler = (String) session.getAttribute("useracc");
		String customername = (String) request.getParameter("customername");
		String phoneStr = (String) request.getParameter("phone");
		String info = (String) request.getParameter("info");
		String deadlineStr = (String) request.getParameter("deadline");
		
		String dev = (String) request.getParameter("dev");
		String orderstatus = "Chưa Làm";
		String webinfo = (String) request.getParameter("webinfo");
		
		
		Date formatter = null;
		try {
			formatter = new SimpleDateFormat("yyyy-MM-dd").parse(deadlineStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date deadline = new java.sql.Date(formatter.getTime());
		
		
		
		Order newOrder = new Order();
		newOrder.setCustomerName(customername);
		newOrder.setPhone(phoneStr);
		newOrder.setInfo(info);
		newOrder.setDeadline(deadline);
		newOrder.setSalerName(saler);
		newOrder.setDevName(dev);
		newOrder.setOrderStatus(orderstatus);
		newOrder.setWebInfo(webinfo);
		
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.addOrder(newOrder);
		response.sendRedirect(request.getContextPath() + "/OrderList");
	}

}
