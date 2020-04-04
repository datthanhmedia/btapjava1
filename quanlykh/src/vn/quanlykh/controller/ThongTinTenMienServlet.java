package vn.quanlykh.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.quanlykh.bo.TenMien;
import vn.quanlykh.dao.TenMienDAO;


/**
 * Servlet implementation class ThongTinTenMienServlet
 */
@WebServlet(name = "ThongTinTenMien", urlPatterns = { "/ThongTinTenMien" })
public class ThongTinTenMienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinTenMienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TenMienDAO tenMienDao = new TenMienDAO();
		
		ArrayList<TenMien> listTenMien =  tenMienDao.tatCaTenMien();
		for(TenMien i: listTenMien) {
			String ngayHetHan = i.getNgayHetHan();
		
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date ngayHienTai = new Date();
			
			Date date1 = null; // Ngày hết hạn
			Date date2 = null; // Ngày hiện tại
			try {
				String ngayHienTaiStr = new SimpleDateFormat("yyyy-MM-dd").format(ngayHienTai);
				date1 = dateFormat.parse(ngayHetHan);
				
				date2 = dateFormat.parse(ngayHienTaiStr);
				long getDiff = date1.getTime() - date2.getTime();
				long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);
				
				
				if(getDaysDiff <=20 && getDaysDiff>0) {
				
					i.setTrangThai("Sắp Hết Hạn");
					tenMienDao.capNhatTrangThai(i);
					
				
				}else if(getDaysDiff<=0) {
					
					i.setTrangThai("Hết Hạn");
					tenMienDao.capNhatTrangThai(i);
				
				}else {
					i.setTrangThai("Đã Đăng Ký");
					tenMienDao.capNhatTrangThai(i);
				}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		ArrayList<TenMien> listTenMienFinal = tenMienDao.tatCaTenMien();
		request.setAttribute("listTenMien", listTenMienFinal);
		RequestDispatcher dispatcher = this.getServletContext().
		getRequestDispatcher("/WEB-INF/views/thongtintenmien.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tukhoa = (String) request.getParameter("tukhoa");
		TenMienDAO tenMienDao = new TenMienDAO();
		ArrayList<TenMien> listTenMien = tenMienDao.timKiemTenMien(tukhoa);
		request.setAttribute("listTenMien", listTenMien);
		RequestDispatcher dispatcher = this.getServletContext().
		getRequestDispatcher("/WEB-INF/views/thongtintenmien.jsp");
		dispatcher.forward(request, response);
	}

}
