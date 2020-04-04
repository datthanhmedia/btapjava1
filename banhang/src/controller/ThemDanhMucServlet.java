package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.DanhMuc;
import dao.DanhMucDAO;

/**
 * Servlet implementation class ThemDanhMucServlet
 */
@WebServlet(name = "them-danh-muc", urlPatterns = { "/them-danh-muc" })
public class ThemDanhMucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemDanhMucServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/themdanhmuc.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String maDanhMuc = (String) request.getParameter("madanhmuc");
		String tenDanhMuc = (String) request.getParameter("tendanhmuc");
		String ghiChu = (String) request.getParameter("ghichu");
		
		DanhMuc danhMuc = new DanhMuc();
		danhMuc.setMaDanhMuc(maDanhMuc);
		danhMuc.setTenDanhMuc(tenDanhMuc);
		danhMuc.setGhiChu(ghiChu);
		
		DanhMucDAO danhMucDao = new DanhMucDAO();
		danhMucDao.themDanhMuc(danhMuc);
		response.sendRedirect(request.getContextPath() + "/them-danh-muc");
	}

}
