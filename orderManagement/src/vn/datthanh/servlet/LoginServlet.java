package vn.datthanh.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.datthanh.bo.User;
import vn.datthanh.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/Login" })
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
		String userName = (String) request.getParameter("useracc");
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
			session.setAttribute("useracc", user.getUserAcc());
			session.setAttribute("username", user.getUserName());
			session.setAttribute("role", user.getRole());
			if(session.getAttribute("role").equals("admin")) {
			response.sendRedirect(request.getContextPath() + "/OrderList");
			}else if(session.getAttribute("role").equals("saler")) {
				response.sendRedirect(request.getContextPath() + "/OrderOfSaler");
			}else {
				response.sendRedirect(request.getContextPath() + "/OrderOfDev");
			}
		}
	}

}
