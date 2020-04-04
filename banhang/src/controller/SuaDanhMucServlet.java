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
 * Servlet implementation class SuaDanhMucServlet
 */
@WebServlet(name = "sua-danh-muc", urlPatterns = { "/sua-danh-muc" })
public class SuaDanhMucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaDanhMucServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
		DanhMucDAO danhMucDao = new DanhMucDAO();
		DanhMuc danhMuc = danhMucDao.getDanhMuc(id);
		request.setAttribute("danhmuc", danhMuc);
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/suadanhmuc.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String maDanhMuc = request.getParameter("madanhmuc");
		String tenDanhMuc = request.getParameter("tendanhmuc");
		String ghiChu = request.getParameter("ghichu");
		DanhMuc danhMuc = new DanhMuc();
		danhMuc.setMaDanhMuc(maDanhMuc);
		danhMuc.setTenDanhMuc(tenDanhMuc);
		danhMuc.setGhiChu(ghiChu);
		danhMuc.setIdDanhMuc(id);
		DanhMucDAO danhMucDao = new DanhMucDAO();
		danhMucDao.suaDanhMuc(danhMuc);
		response.sendRedirect(request.getContextPath() + "/danh-muc");
		
	}

}
