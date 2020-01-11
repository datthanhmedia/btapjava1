package vn.quanlykh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.quanlykh.bo.QuanTri;
import vn.quanlykh.dao.QuanTriDAO;


/**
 * Servlet implementation class DangNhapServlet
 */
@WebServlet(name = "DangNhap", urlPatterns = { "/DangNhap" })
public class DangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/dangnhap.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = (String) request.getParameter("user");
		String password = (String) request.getParameter("password");
		QuanTriDAO quanTriDao = new QuanTriDAO();
		QuanTri quanTri = quanTriDao.findUser(userName, password);
		if(quanTri == null) {
			request.setAttribute("errormessage", "Login failed");
			RequestDispatcher dispatcher =
					this.getServletContext().getRequestDispatcher("/WEB-INF/views/dangnhap.jsp");
					dispatcher.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", quanTri.getTaiKhoan());
			session.setAttribute("role", quanTri.getRole());
			if(session.getAttribute("role").equals("admin")) {
			response.sendRedirect(request.getContextPath() + "/ThongTinKhachHang");
			}else if(session.getAttribute("role").equals("nhanvien")) {
				response.sendRedirect(request.getContextPath() + "/ThongTinKhachHang");
			}
		}
	}

}
