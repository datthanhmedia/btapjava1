package vn.quanlykh.controller;

import java.io.IOException;

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
 * Servlet implementation class SuaTenMienServlet
 */
@WebServlet(name = "SuaTenMien", urlPatterns = { "/SuaTenMien" })
public class SuaTenMienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaTenMienServlet() {
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
		request.setAttribute("tenMien", tenMien);
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/suatenmien.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 	
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession(false);
		String idStr = (String) request.getParameter("id");
		String tenMien = (String) request.getParameter("tenmien");
		String trangThai = "Đã đăng ký";
		String ngaydangkyStr = (String) request.getParameter("ngaydangky");
		String hosting = (String) request.getParameter("hosting");
		int id = Integer.parseInt(idStr);
		String ngaydangky[]= ngaydangkyStr.split("-");
		int namdk = Integer.parseInt(ngaydangky[0]);
		int namhethan = namdk+1;
		String ngayDangKy = String.valueOf(namdk) + "-" + ngaydangky[1] + "-" + ngaydangky[2];
		
		String ngayHetHan = String.valueOf(namhethan) + "-" + ngaydangky[1] + "-" + ngaydangky[2];
		TenMien nhapTenMien = new TenMien();
		nhapTenMien.setId(id);
		nhapTenMien.setTenMien(tenMien);
		nhapTenMien.setTrangThai(trangThai);
		nhapTenMien.setNgayDangKy(ngayDangKy);
		nhapTenMien.setNgayHetHan(ngayHetHan);
		nhapTenMien.setHosting(hosting);
		
		TenMienDAO tenMienDAO = new TenMienDAO();
		tenMienDAO.suaTenMien(nhapTenMien);;
		response.sendRedirect(request.getContextPath() + "/ThongTinTenMien");
	}

}
