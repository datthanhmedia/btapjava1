package vn.quanlykh.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import vn.quanlykh.bo.TenMien;
import vn.quanlykh.dao.TenMienDAO;

/**
 * Servlet implementation class CapNhatTenMienServlet
 */
@WebServlet(name = "CapNhatTenMien", urlPatterns = { "/CapNhatTenMien" })
public class CapNhatTenMienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapNhatTenMienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 	
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession(false);
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		TenMien tenMien = new TenMien();
		String ngayHetHan = tenMien.getNgayHetHan();
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ngayHetHan);
			c1.setTime(date);
			Date ngayHienTai = new Date();
			c2.setTime(ngayHienTai);
			long soNgay = (c2.getTime().getTime() - c1.getTime().getTime());
			TenMienDAO tenMienDao = new TenMienDAO();
			if(soNgay <=20) {
				tenMien.setTrangThai("Sắp Hết Hạn");
				tenMienDao.capNhatTrangThai(tenMien);
			}else if(soNgay<=0) {
				tenMien.setTrangThai("Hết Hạn");
				tenMienDao.capNhatTrangThai(tenMien);
			}
		} catch (ParseException e) {
				
				
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
