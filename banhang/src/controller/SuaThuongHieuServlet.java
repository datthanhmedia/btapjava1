package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.ThuongHieu;
import dao.ThuongHieuDAO;


/**
 * Servlet implementation class SuaThuongHieuServlet
 */
@WebServlet(name = "sua-thuong-hieu", urlPatterns = { "/sua-thuong-hieu" })
public class SuaThuongHieuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaThuongHieuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
		ThuongHieuDAO thuongHieuDao = new ThuongHieuDAO();
		ThuongHieu thuongHieu = thuongHieuDao.getThuongHieu(id);
		request.setAttribute("thuonghieu", thuongHieu);
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/suathuonghieu.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String mathuongHieu = request.getParameter("mathuonghieu");
		String tenthuongHieu = request.getParameter("tenthuonghieu");
		String ghiChu = request.getParameter("ghichu");
		ThuongHieu thuongHieu = new ThuongHieu();
		thuongHieu.setMaThuongHieu(mathuongHieu);
		thuongHieu.setTenThuongHieu(tenthuongHieu);
		thuongHieu.setGhiChu(ghiChu);
		thuongHieu.setIdThuongHieu(id);
		ThuongHieuDAO thuongHieuDao = new ThuongHieuDAO();
		thuongHieuDao.suaThuongHieu(thuongHieu);
		response.sendRedirect(request.getContextPath() + "/thuong-hieu");
	}

}
