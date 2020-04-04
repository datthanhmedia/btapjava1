package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.SanPham;
import dao.SanPhamDAO;

/**
 * Servlet implementation class ThemVaoGioHangServlet
 */
@WebServlet(name = "them-vao-gio", urlPatterns = { "/them-vao-gio" })
public class ThemVaoGioHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemVaoGioHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String maSanPham = (String) request.getParameter("masanpham");
		String soLuongStr = (String) request.getParameter("soluong");
		String donGiaStr1 = (String) request.getParameter("giaban");
		String chietKhauStr1 = (String) request.getParameter("chietkhau");
		String chietKhauStr = chietKhauStr1.replace(",", "");
		String donGiaStr = donGiaStr1.replace(",", "");
		int soLuong = Integer.parseInt(soLuongStr);
		int donGia = Integer.parseInt(donGiaStr);
		int chietKhau = Integer.parseInt(chietKhauStr);
		SanPhamDAO sanPhamDao = new SanPhamDAO();
		SanPham sp = sanPhamDao.getSanPham(maSanPham);
		SanPham sanPhamMoi = new SanPham();
		sanPhamMoi.setMaSanPham(maSanPham);
		sanPhamMoi.setSoLuong(soLuong);
		sanPhamMoi.setGiaBan(donGia);
		sanPhamMoi.setChietKhau(chietKhau);
		sanPhamMoi.setVat(sp.getVat());
		sanPhamDao.themGioHang(sanPhamMoi);
		response.sendRedirect(request.getContextPath() + "/ban-hang");
	}

}
