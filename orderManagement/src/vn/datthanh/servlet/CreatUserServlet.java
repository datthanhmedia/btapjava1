package vn.datthanh.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.datthanh.bo.User;
import vn.datthanh.dao.UserDAO;

/**
 * Servlet implementation class CreatUserServlet
 */
@WebServlet(name = "CreatUser", urlPatterns = { "/CreatUser" })
public class CreatUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/creatuser.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 	
		
		String username = (String) request.getParameter("username");
		String userinfo = (String) request.getParameter("userinfo");
		String useracc = (String) request.getParameter("useracc");
		String password = (String) request.getParameter("password");
		String role = (String) request.getParameter("role");
		User newUser = new User();
		newUser.setUserName(username);
		newUser.setUserInfo(userinfo);
		newUser.setUserAcc(useracc);
		newUser.setPassword(password);
		newUser.setRole(role);
		UserDAO userDAO = new UserDAO();
		userDAO.insertUser(newUser);
		response.sendRedirect(request.getContextPath() + "/UserList");
	}

}
