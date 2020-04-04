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
 * Servlet implementation class SuaNhaCungCapServlet
 */
@WebServlet(name = "sua-nha-cung-cap", urlPatterns = { "/sua-nha-cung-cap" })
public class SuaNhaCungCapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaNhaCungCapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
		NhaCungCapDAO nhaCungCapDao = new NhaCungCapDAO();
		NhaCungCap nhaCungCap = nhaCungCapDao.getNhaCungCap(id);
		request.setAttribute("nhacungcap", nhaCungCap);
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/suanhacungcap.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String maNhaCungCap = request.getParameter("manhacungcap");
		String tenNhaCungCap = request.getParameter("tennhacungcap");
		String loai = request.getParameter("loai");
		String lienHe = request.getParameter("lienhe");
		String ghiChu = request.getParameter("ghichu");
		NhaCungCap nhaCungCap = new NhaCungCap();
		nhaCungCap.setMaNhaCungCap(maNhaCungCap);
		nhaCungCap.setTenNhaCungCap(tenNhaCungCap);
		nhaCungCap.setLoai(loai);
		nhaCungCap.setLienHe(lienHe);
		nhaCungCap.setGhiChu(ghiChu);
		nhaCungCap.setIdNhaCungCap(id);
		NhaCungCapDAO nhaCungCapDao = new NhaCungCapDAO();
		nhaCungCapDao.suaNhaCungCap(nhaCungCap);
		response.sendRedirect(request.getContextPath() + "/nha-cung-cap");
	}

}
