package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.KhoHang;
import bo.SanPhamDaBan;
import dao.KhoHangDAO;
import dao.SanPhamDAO;
import dao.SanPhamDaBanDAO;

/**
 * Servlet implementation class XoaSanPhamServlet
 */
@WebServlet(name = "xoa-san-pham", urlPatterns = { "/xoa-san-pham" })
public class XoaSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSanPham = (String) request.getParameter("masanpham");
		SanPhamDAO sanPhamDao = new SanPhamDAO();
		
		KhoHangDAO khoHangDao = new KhoHangDAO();
		ArrayList<KhoHang> spXoa = khoHangDao.getKhoHang(maSanPham);
		
		for(int i = 0; i<spXoa.size();i++) {
			khoHangDao.xoaKhoHang(spXoa.get(i).getId());
		}
		SanPhamDaBanDAO spdbDao = new SanPhamDaBanDAO();
		ArrayList<SanPhamDaBan> spdbXoa = spdbDao.getSanPhamDaBan(maSanPham);
		
		for(int i = 0; i<spdbXoa.size();i++) {
			spdbDao.xoaSanPhamDaBan(spdbXoa.get(i).getId());
		}
		
		sanPhamDao.xoaSanPham(maSanPham);
		response.sendRedirect(request.getContextPath() + "/san-pham");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
