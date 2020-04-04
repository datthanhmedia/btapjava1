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
import bo.SanPham;
import bo.SanPhamDaBan;
import dao.KhachHangDAO;
import dao.SanPhamDAO;
import dao.SanPhamDaBanDAO;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(name = "home", urlPatterns = { "/home" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SanPhamDAO sanPhamDao = new SanPhamDAO();
		ArrayList<SanPham> tatCaSanPham = sanPhamDao.tatCaSanPham();
		int soLuongNhap = 0;
		for(int i = 0; i < tatCaSanPham.size();i++) {
			soLuongNhap += tatCaSanPham.get(i).getSoLuong();
		}
		request.setAttribute("soluongnhap", soLuongNhap);
		int tongtien = 0;
		SanPhamDaBanDAO sanPhamDaBanDao = new SanPhamDaBanDAO();
		ArrayList<SanPhamDaBan> spDaBan = sanPhamDaBanDao.tatCaSanPhamDaBan();
		int soLuongXuat = 0;
		for(int i = 0; i < spDaBan.size();i++) {
			soLuongXuat += spDaBan.get(i).getSoLuong();
			tongtien+=((spDaBan.get(i).getGiaBan()+spDaBan.get(i).getGiaBan()*spDaBan.get(i).getVat()/100)
					-(spDaBan.get(i).getChietKhau()*spDaBan.get(i).getGiaBan()*spDaBan.get(i).getSoLuong()/100));
		}
		request.setAttribute("soluongxuat", soLuongXuat);
		request.setAttribute("tongtien", tongtien);
		KhachHangDAO khachHangDao = new KhachHangDAO();
		ArrayList<KhachHang> khachHang = khachHangDao.tatCaKhachHang();
		int soLuongKhachHang = 0;
		
		for(int i = 0; i < khachHang.size();i++) {
			soLuongKhachHang += 1;
		}
		request.setAttribute("soluongkhachhang", soLuongKhachHang);
		
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
