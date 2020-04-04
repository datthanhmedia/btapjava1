package controller;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.DanhMuc;
import bo.DonVi;
import bo.KhoHang;
import bo.NhaCungCap;
import bo.SanPham;
import bo.ThuongHieu;
import dao.DanhMucDAO;
import dao.DonViDAO;
import dao.KhoHangDAO;
import dao.NhaCungCapDAO;
import dao.SanPhamDAO;
import dao.ThuongHieuDAO;

/**
 * Servlet implementation class ThemSanPhamServlet
 */
@WebServlet(name = "them-san-pham", urlPatterns = { "/them-san-pham" })
public class ThemSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemSanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DonViDAO donViDao = new DonViDAO();
		ArrayList<DonVi> donVi = donViDao.tatCaDonVi();
		request.setAttribute("donvi", donVi);
		
		DanhMucDAO danhMucDao = new DanhMucDAO();
		ArrayList<DanhMuc> tatCaDanhMuc = danhMucDao.tatCaDanhMuc();
		request.setAttribute("danhmuc", tatCaDanhMuc);
		
		ThuongHieuDAO thuongHieuDao = new ThuongHieuDAO();
		ArrayList<ThuongHieu> tatCaThuongHieu = thuongHieuDao.tatCaThuongHieu();
		request.setAttribute("thuonghieu", tatCaThuongHieu);
		
		NhaCungCapDAO nhaCungCap = new NhaCungCapDAO();
		ArrayList<NhaCungCap> tatCaNhaCungCap = nhaCungCap.tatCaNhaCungCap();
		request.setAttribute("nhacungcap", tatCaNhaCungCap);
		
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/themsanpham.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tenSanPham = (String) request.getParameter("tensanpham");
		String maVach = (String) request.getParameter("mavach");
		String maSanPham = (String) request.getParameter("masanpham");
		String giaVonStr = (String) request.getParameter("giavon");
		String giaBanStr = (String) request.getParameter("giaban");
		String giaBuonStr = (String) request.getParameter("giabuon");
		String soLuongStr = (String) request.getParameter("soluong");
		String donVi = (String) request.getParameter("donvi");
		String vatStr = (String) request.getParameter("vat");
		String danhMuc = (String) request.getParameter("danhmuc");
		String thuongHieu = (String) request.getParameter("thuonghieu");
		String nhaCungCap = (String) request.getParameter("nhacungcap");
		//Chuyen doi str to int
		String giaVon1 = giaVonStr.replace(",", "");
		String giaBan1 = giaBanStr.replace(",", "");
		String giaBuon1 = giaBuonStr.replace(",", "");
		int giaVon = Integer.parseInt(giaVon1);
		int giaBan = Integer.parseInt(giaBan1);
		int giaBuon = Integer.parseInt(giaBuon1);
		int soLuong = Integer.parseInt(soLuongStr);
		int vat = Integer.parseInt(vatStr);
		//Them vao san pham
		SanPham sanPhamMoi = new SanPham();
		sanPhamMoi.setTenSanPham(tenSanPham);
		sanPhamMoi.setMaVach(maVach);
		sanPhamMoi.setMaSanPham(maSanPham);
		sanPhamMoi.setGiaVon(giaVon);
		sanPhamMoi.setGiaBan(giaBan);
		sanPhamMoi.setGiaBuon(giaBuon);
		sanPhamMoi.setSoLuong(soLuong);;
		sanPhamMoi.setDonVi(donVi);
		sanPhamMoi.setVat(vat);
		sanPhamMoi.setDanhMuc(danhMuc);
		sanPhamMoi.setThuongHieu(thuongHieu);
		sanPhamMoi.setNhaCungCap(nhaCungCap);
		sanPhamMoi.setConLai(soLuong);
		
		//Lay ngay hien tai
		long millis=System.currentTimeMillis();  
		Date date=new Date(millis); 
		String format = "dd-MM-yyyy";
		SimpleDateFormat df = new SimpleDateFormat(format);
		String ngay = df.format(date);
		//Them vao kho hang
		KhoHang nhapKho = new KhoHang();
		nhapKho.setMaSanPham(maSanPham);;
		nhapKho.setKieu("Nhập");
		nhapKho.setNgay(ngay);
		nhapKho.setSoLuongNhap(soLuong);
		nhapKho.setTonKho(soLuong);
		//Them vao database
		KhoHangDAO nhapKhoDao = new KhoHangDAO();
		nhapKhoDao.themKhoHang(nhapKho);
		
		SanPhamDAO sanPhamDao = new SanPhamDAO();
		sanPhamDao.themSanPham(sanPhamMoi);

		response.sendRedirect(request.getContextPath() + "/them-san-pham");
	}
	
}
