package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ThuongHieuDAO;

/**
 * Servlet implementation class XoaThuongHieuServlet
 */
@WebServlet(name = "xoa-thuong-hieu", urlPatterns = { "/xoa-thuong-hieu" })
public class XoaThuongHieuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaThuongHieuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
		ThuongHieuDAO thuongHieuDao = new ThuongHieuDAO();
		thuongHieuDao.xoaThuongHieu(id);
		response.sendRedirect(request.getContextPath() + "/thuong-hieu");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
