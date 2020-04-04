package vn.quanlykh.controller;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.quanlykh.bo.KhachHang;
import vn.quanlykh.dao.KhachHangDAO;

/**
 * Servlet implementation class ThongTinKhachHang
 */
@WebServlet(name = "ThongTinKhachHang", urlPatterns = { "/ThongTinKhachHang" })
public class ThongTinKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinKhachHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KhachHangDAO khachHangDao = new KhachHangDAO();
		ArrayList<KhachHang> listKhachHang =  khachHangDao.tatCaKhachHang();
		
		request.setAttribute("listKhachHang", listKhachHang);
		RequestDispatcher dispatcher = this.getServletContext().
		getRequestDispatcher("/WEB-INF/views/thongtinkhachhang.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tukhoa = (String) request.getParameter("tukhoa");
		KhachHangDAO khachHangDao = new KhachHangDAO();
		ArrayList<KhachHang> listKhachHang =  khachHangDao.timKiemKhachHang(tukhoa);
		request.setAttribute("listKhachHang", listKhachHang);
		RequestDispatcher dispatcher = this.getServletContext().
		getRequestDispatcher("/WEB-INF/views/thongtinkhachhang.jsp");
		dispatcher.forward(request, response);
	}

}
