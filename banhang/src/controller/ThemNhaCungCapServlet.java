package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.NhaCungCap;
import dao.NhaCungCapDAO;


/**
 * Servlet implementation class ThemNhaCungCapServlet
 */
@WebServlet(name = "them-nha-cung-cap", urlPatterns = { "/them-nha-cung-cap" })
public class ThemNhaCungCapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemNhaCungCapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/themnhacungcap.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String maNhaCungCap = (String) request.getParameter("manhacungcap");
		String tenNhaCungCap = (String) request.getParameter("tennhacungcap");
		String loai = (String) request.getParameter("loai");
		String lienHe = (String) request.getParameter("lienhe");
		String ghiChu = (String) request.getParameter("ghichu");
		
		NhaCungCap nhaCungCap = new NhaCungCap();
		nhaCungCap.setMaNhaCungCap(maNhaCungCap);
		nhaCungCap.setTenNhaCungCap(tenNhaCungCap);
		nhaCungCap.setLoai(loai);
		nhaCungCap.setLienHe(lienHe);
		nhaCungCap.setGhiChu(ghiChu);
		
		NhaCungCapDAO NhaCungCapDao = new NhaCungCapDAO();
		NhaCungCapDao.themNhaCungCap(nhaCungCap);
		response.sendRedirect(request.getContextPath() + "/them-nha-cung-cap");
	}

}
