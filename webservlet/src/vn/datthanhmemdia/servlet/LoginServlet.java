package vn.datthanhmemdia.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.datthanhmedia.bo.User;
import vn.datthanhmedia.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findUserByUsernameAndPassword(userName, password);
		if(user == null) {
			request.setAttribute("errormessage", "Login failed");
			RequestDispatcher dispatcher =
					this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
					dispatcher.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUser());
			if(user.getRole() == 1) {
				session.setAttribute("role", "user");
			}else if(user.getRole() == 0) {
				session.setAttribute("role", "admin");
			}
			
			response.sendRedirect(request.getContextPath() + "/home");
		}
	}

}
