package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.KhachHang;
import bo.User;
import dao.KhachHangDAO;
import dao.UserDAO;

/**
 * Servlet implementation class SuaKhachHangServlet
 */
@WebServlet(name = "sua-khach-hang", urlPatterns = { "/sua-khach-hang" })
public class SuaKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaKhachHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maKhachHang = (String) request.getParameter("makhachhang");
		KhachHangDAO khachHangDao = new KhachHangDAO();
		KhachHang khachHang = khachHangDao.getKhachHangByMa(maKhachHang);
		request.setAttribute("khachhang", khachHang);
		UserDAO userDao = new UserDAO();
		ArrayList<User> nhanVien = userDao.getUserByRole(0);
		request.setAttribute("nhanvien", nhanVien);
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/suakhachhang.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String maKhachHang = (String) request.getParameter("makhachhang");
		String tenKhachHang = (String) request.getParameter("tenkhachhang");
		String loai = (String) request.getParameter("loai");
		String dienThoai = (String) request.getParameter("dienthoai");
		String email = (String) request.getParameter("email");
		String facebook = (String) request.getParameter("facebook");
		String ngaySinh = (String) request.getParameter("ngaysinh");
		String gioiTinh = (String) request.getParameter("gioitinh");
		String diaChi = (String) request.getParameter("diachi");
		String mst = (String) request.getParameter("mst");
		String cmnd = (String) request.getParameter("cmnd");
		String ghiChu = (String) request.getParameter("ghiChu");
		String nhanVien = (String) request.getParameter("nhanvien");
		
		KhachHang khachHang = new KhachHang();
		khachHang.setMaKhachHang(maKhachHang);
		khachHang.setHoTen(tenKhachHang);
		khachHang.setLoai(loai);
		khachHang.setDienThoai(dienThoai);
		khachHang.setEmail(email);
		khachHang.setFacebook(facebook);
		khachHang.setNgaySinh(ngaySinh);
		khachHang.setGioiTinh(gioiTinh);
		khachHang.setDiaChi(diaChi);
		khachHang.setMST(mst);
		khachHang.setCMND(cmnd);
		khachHang.setGhiChu(ghiChu);
		khachHang.setNhanVien(nhanVien);
		KhachHangDAO khachHangDao = new KhachHangDAO();
		khachHangDao.suaKhachHang(khachHang);
		response.sendRedirect(request.getContextPath() + "/khach-hang");
	}

}
