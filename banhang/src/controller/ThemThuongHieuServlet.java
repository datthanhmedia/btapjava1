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
 * Servlet implementation class ThemThuongHieuServlet
 */
@WebServlet(name = "them-thuong-hieu", urlPatterns = { "/them-thuong-hieu" })
public class ThemThuongHieuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemThuongHieuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/themthuonghieu.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String maThuongHieu = (String) request.getParameter("mathuonghieu");
		String tenThuongHieu = (String) request.getParameter("tenthuonghieu");
		String ghiChu = (String) request.getParameter("ghichu");
		
		ThuongHieu thuongHieu = new ThuongHieu();
		thuongHieu.setMaThuongHieu(maThuongHieu);
		thuongHieu.setTenThuongHieu(tenThuongHieu);
		thuongHieu.setGhiChu(ghiChu);
		
		ThuongHieuDAO danhMucDao = new ThuongHieuDAO();
		danhMucDao.themThuongHieu(thuongHieu);
		response.sendRedirect(request.getContextPath() + "/them-thuong-hieu");
	}

}
