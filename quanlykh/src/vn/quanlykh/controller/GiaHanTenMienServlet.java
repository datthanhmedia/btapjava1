package vn.quanlykh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.quanlykh.bo.TenMien;
import vn.quanlykh.dao.TenMienDAO;

/**
 * Servlet implementation class GiaHanTenMienServlet
 */
@WebServlet(name = "GiaHanTenMien", urlPatterns = { "/GiaHanTenMien" })
public class GiaHanTenMienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiaHanTenMienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
		TenMienDAO tenMienDao = new TenMienDAO();
		TenMien tenMien = tenMienDao.idTenMien(id);
		String ngayDangKyStr = tenMien.getNgayDangKy();
		String ngaydangky[]= ngayDangKyStr.split("-");
		int namdk = Integer.parseInt(ngaydangky[0]) + 1;
		int namhethan = namdk+1;
		String ngayDangKy = String.valueOf(namdk) + "-" + ngaydangky[1] + "-" + ngaydangky[2];
		String ngayHetHan = String.valueOf(namhethan) + "-" + ngaydangky[1] + "-" + ngaydangky[2];
		tenMien.setNgayDangKy(ngayDangKy);
		tenMien.setNgayHetHan(ngayHetHan);
		tenMienDao.giaHanTenMien(tenMien);
		response.sendRedirect(request.getContextPath() + "/ThongTinTenMien");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
