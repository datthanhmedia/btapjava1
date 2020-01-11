package vn.datthanh.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.datthanh.bo.Order;
import vn.datthanh.dao.OrderDAO;



/**
 * Servlet implementation class UpdateStatusServlet
 */
@WebServlet(name = "UpdateStatus", urlPatterns = { "/UpdateStatus" })
public class UpdateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    int id;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = (String) request.getParameter("id");
		id = Integer.parseInt(idStr);
		
		OrderDAO orderDAO = new OrderDAO();
		Order listOrder = orderDAO.getOrder(id);
		request.setAttribute("listOrder", listOrder);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/updatestatus.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String status = (String) request.getParameter("orderstatus");
		String webinfo = (String) request.getParameter("webinfo");
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.updateStatus(id, status, webinfo);
		response.sendRedirect(request.getContextPath() + "/OrderOfDev");
	}

}
