package vn.quanlykh.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.quanlykh.bo.TenMien;
import vn.quanlykh.dao.TenMienDAO;


/**
 * Servlet implementation class ThemTenMienServlet
 */
@WebServlet(name = "ThemTenMien", urlPatterns = { "/ThemTenMien" })
public class ThemTenMienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemTenMienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/themtenmien.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 	
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession(false);
		String tenMien = (String) request.getParameter("tenmien");
		String trangThai = "Đã đăng ký";
		String ngaydangkyStr = (String) request.getParameter("ngaydangky");
		String hosting = (String) request.getParameter("hosting");
		String ngaydangky[]= ngaydangkyStr.split("-");
		int namdk = Integer.parseInt(ngaydangky[0]);
		int namhethan = namdk+1;
		String ngayDangKy = String.valueOf(namdk) + "-" + ngaydangky[1] + "-" + ngaydangky[2];
		String ngayHetHan = String.valueOf(namhethan) + "-" + ngaydangky[1] + "-" + ngaydangky[2];
		TenMien nhapTenMien = new TenMien();
		nhapTenMien.setTenMien(tenMien);
		nhapTenMien.setTrangThai(trangThai);
		nhapTenMien.setNgayDangKy(ngayDangKy);
		nhapTenMien.setNgayHetHan(ngayHetHan);
		nhapTenMien.setHosting(hosting);
		
		TenMienDAO tenMienDAO = new TenMienDAO();
		tenMienDAO.themTenMien(nhapTenMien);;
		response.sendRedirect(request.getContextPath() + "/ThongTinTenMien");
	}

	

}
