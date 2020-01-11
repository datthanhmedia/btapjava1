package vn.quanlykh.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.quanlykh.bo.KhachHang;
import vn.quanlykh.dao.KhachHangDAO;

/**
 * Servlet implementation class ThemKhachHang
 */
@WebServlet(name = "ThemKhachHang", urlPatterns = { "/ThemKhachHang" })
public class ThemKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemKhachHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/themkhachhang.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 	
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession(false);
		String tenkh = (String) request.getParameter("tenkh");
		String thongtin = (String) request.getParameter("thongtin");
		String trangthaiStr = (String) request.getParameter("trangthai");
		String sdt = (String) request.getParameter("sdt");
		String tenmien = (String) request.getParameter("tenmien");
		String ngay = (String) request.getParameter("ngay");
		String sale = (String) request.getParameter("sale");
		int trangthaiint = Integer.parseInt(trangthaiStr);
		String trangthai;
		if(trangthaiint==0) {
			trangthai="Chưa Làm";
		}else {
			trangthai="Đã Làm";
		}
		
		KhachHang khachHang = new KhachHang();
		khachHang.setTenKH(tenkh);
		khachHang.setThongTin(thongtin);
		khachHang.setTrangThai(trangthai);;
		khachHang.setSdt(sdt);
		khachHang.setTenMien(tenmien);
		khachHang.setNgay(ngay);
		khachHang.setSale(sale);
		
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		khachHangDAO.themKhachHang(khachHang);
		response.sendRedirect(request.getContextPath() + "/ThongTinKhachHang");
	}

}
