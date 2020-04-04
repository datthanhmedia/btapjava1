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
 * Servlet implementation class SuaDonViServlet
 */
@WebServlet(name = "sua-don-vi", urlPatterns = { "/sua-don-vi" })
public class SuaDonViServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaDonViServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
		DonViDAO donViDao = new DonViDAO();
		DonVi donVi = donViDao.getDonVi(id);
		request.setAttribute("donvi", donVi);
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/suadonvi.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String tenDonVi = (String) request.getParameter("donvi");
		String ghiChu = (String) request.getParameter("ghichu");
		
		DonVi donVi = new DonVi();
		donVi.setIdDonVi(id);
		donVi.setDonVi(tenDonVi);
		donVi.setGhiChu(ghiChu);
		DonViDAO donViDao = new DonViDAO();
		donViDao.suaDonVi(donVi);
		response.sendRedirect(request.getContextPath() + "/don-vi");
	}

}
