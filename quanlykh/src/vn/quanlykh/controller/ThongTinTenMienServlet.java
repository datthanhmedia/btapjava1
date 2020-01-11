package vn.quanlykh.controller;

import java.io.IOException;
import java.util.ArrayList;

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
		
		request.setAttribute("listTenMien", listTenMien);
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
