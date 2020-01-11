package vn.datthanh.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.datthanh.bo.Order;
import vn.datthanh.bo.User;
import vn.datthanh.dao.OrderDAO;
import vn.datthanh.dao.UserDAO;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet(name = "UserList", urlPatterns = { "/UserList" })
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userdao = new UserDAO();
		ArrayList<User> listUser = userdao.getUser();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = this.getServletContext().
		getRequestDispatcher("/WEB-INF/views/listuser.jsp");
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
