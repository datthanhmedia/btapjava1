package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.DonVi;
import dao.DonViDAO;

/**
 * Servlet implementation class ThemDonViServlet
 */
@WebServlet(name = "them-don-vi", urlPatterns = { "/them-don-vi" })
public class ThemDonViServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemDonViServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/themdonvi.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tenDonVi = (String) request.getParameter("donvi");
		String ghiChu = (String) request.getParameter("ghichu");
		
		DonVi donVi = new DonVi();
		donVi.setDonVi(tenDonVi);
		donVi.setGhiChu(ghiChu);
		DonViDAO donViDao = new DonViDAO();
		donViDao.themDonVi(donVi);
		response.sendRedirect(request.getContextPath() + "/them-don-vi");
	}

}
