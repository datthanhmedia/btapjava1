package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.KhachHang;
import bo.KhoHang;
import bo.SanPham;
import bo.SanPhamDaBan;
import bo.User;
import dao.KhachHangDAO;
import dao.KhoHangDAO;
import dao.SanPhamDAO;
import dao.SanPhamDaBanDAO;
import dao.UserDAO;

/**
 * Servlet implementation class BanHangServlet
 */
@WebServlet(name = "ban-hang", urlPatterns = { "/ban-hang" })
public class BanHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BanHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SanPhamDAO sanPhamDao = new SanPhamDAO();
		ArrayList<SanPham> sanPham = sanPhamDao.tatCaSanPham();
		request.setAttribute("sanpham", sanPham);
		UserDAO userDao = new UserDAO();
		ArrayList<User> nhanVien = userDao.getUserByRole(0);
		request.setAttribute("nhanvien", nhanVien);
		KhachHangDAO khachHangDao = new KhachHangDAO();
		ArrayList<KhachHang> khachHang = khachHangDao.tatCaKhachHang();
		request.setAttribute("khachhang", khachHang);
		ArrayList<SanPhamDaBan> gioHang1 = sanPhamDao.gioHang();
		if(gioHang1!=null) {
		ArrayList<SanPhamDaBan> gioHang = new ArrayList<SanPhamDaBan>();
		for (int i = 0; i < gioHang1.size(); i++) {
			SanPham sp = sanPhamDao.getSanPham(gioHang1.get(i).getMaSanPham());
			
			gioHang1.get(i).setTenSanPham(sp.getTenSanPham());
			gioHang1.get(i).setDonVi(sp.getDonVi());
			gioHang.add(gioHang1.get(i));
		}
		request.setAttribute("giohang", gioHang);
		}else
			request.setAttribute("giohang", gioHang1);
		RequestDispatcher dispatcher = this.getServletContext().
				getRequestDispatcher("/WEB-INF/views/banhang.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String maKhachHang = (String) request.getParameter("makhachhang");
		String userNameNhanVien = (String) request.getParameter("nhanvien");
		String ghiChu = (String) request.getParameter("ghichu");
		SanPhamDAO sanPhamDao = new SanPhamDAO();
		KhoHangDAO khoHangDao = new KhoHangDAO();
		KhoHang khoHang = new KhoHang();
		SanPhamDaBanDAO sanPhamDaBanDao = new SanPhamDaBanDAO();
	
		ArrayList<SanPhamDaBan> spBan1 = sanPhamDao.gioHang();
		long millis=System.currentTimeMillis();  
		Date date=new Date(millis); 
		String format = "dd-MM-yyyy";
		SimpleDateFormat df = new SimpleDateFormat(format);
		String ngay = df.format(date);
		SanPhamDaBan spBan = new SanPhamDaBan();
		for (int i = 0; i < spBan1.size(); i++) {
			SanPham sp = sanPhamDao.getSanPham(spBan1.get(i).getMaSanPham());
			spBan.setMaVach(sp.getMaVach());
			spBan.setMaSanPham(sp.getMaSanPham());
			spBan.setTenSanPham(sp.getTenSanPham());
			spBan.setGiaBan(sp.getGiaBan());
			spBan.setGiaVon(sp.getGiaVon());
			spBan.setSoLuong(spBan1.get(i).getSoLuong());
			spBan.setChietKhau(sp.getChietKhau());
			spBan.setGhiChu(ghiChu);
			spBan.setNhanVien(userNameNhanVien);
			spBan.setKhachHang(maKhachHang);
			spBan.setNgay(ngay);
			sanPhamDao.banHang(sp.getConLai() - spBan1.get(i).getSoLuong(), spBan1.get(i).getMaSanPham());
			sanPhamDaBanDao.themSanPhamDaBan(spBan);
			khoHang.setMaSanPham(spBan1.get(i).getMaSanPham());
			khoHang.setChietKhau(spBan1.get(i).getChietKhau());
			khoHang.setKieu("Xuất");
			khoHang.setSoLuongXuat(spBan1.get(i).getSoLuong());
			khoHang.setNgay(ngay);
			khoHang.setTonKho(sp.getConLai() - spBan1.get(i).getSoLuong());
			khoHang.setGhiChu(ghiChu);
			khoHangDao.themKhoHang(khoHang);
			sanPhamDao.xoaGioHang();
			
		}
		response.sendRedirect(request.getContextPath() + "/kho-hang");
	}

}
