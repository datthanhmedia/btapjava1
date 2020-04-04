package controller;

import java.io.IOException;
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
 * Servlet implementation class SuaSanPhamServlet
 */
@WebServlet(name = "sua-san-pham", urlPatterns = { "/sua-san-pham" })
public class SuaSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaSanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSanPham = (String) request.getParameter("masanpham");
		SanPhamDAO sanPhamDao = new SanPhamDAO();
		SanPham sanPham = sanPhamDao.getSanPham(maSanPham);
		
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
		
		request.setAttribute("sanpham", sanPham);
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/suasanpham.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
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
		
		String giaVon1 = giaVonStr.replace(",", "");
		String giaBan1 = giaBanStr.replace(",", "");
		String giaBuon1 = giaBuonStr.replace(",", "");
		//Chuyen doi str to int
				int giaVon = Integer.parseInt(giaVon1);
				int giaBan = Integer.parseInt(giaBan1);
				int giaBuon = Integer.parseInt(giaBuon1);
				int soLuong = Integer.parseInt(soLuongStr);
				int vat = Integer.parseInt(vatStr);
				
				
		SanPham sua = new SanPham();
		sua.setId(id);
		sua.setTenSanPham(tenSanPham);
		sua.setMaVach(maVach);
		sua.setMaSanPham(maSanPham);
		sua.setGiaVon(giaVon);
		sua.setGiaBan(giaBan);
		sua.setGiaBuon(giaBuon);
		sua.setSoLuong(soLuong);;
		sua.setDonVi(donVi);
		sua.setVat(vat);
		sua.setDanhMuc(danhMuc);
		sua.setThuongHieu(thuongHieu);
		sua.setNhaCungCap(nhaCungCap);
		sua.setConLai(soLuong);
		
		KhoHang nhapKho = new KhoHang();
		nhapKho.setMaSanPham(maSanPham);
		nhapKho.setKieu("Nhập");
		nhapKho.setTonKho(soLuong);
		
		//Them vao database
				KhoHangDAO nhapKhoDao = new KhoHangDAO();
				nhapKhoDao.suaKhoHang(nhapKho);
				
				SanPhamDAO sanPhamDao = new SanPhamDAO();
				sanPhamDao.suaSanPham(sua);
				response.sendRedirect(request.getContextPath() + "/san-pham");
	}

}
