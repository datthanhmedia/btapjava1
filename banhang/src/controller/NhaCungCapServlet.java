package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.NhaCungCap;
import dao.NhaCungCapDAO;

/**
 * Servlet implementation class NhaCungCapServlet
 */
@WebServlet(name = "nha-cung-cap", urlPatterns = { "/nha-cung-cap" })
public class NhaCungCapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NhaCungCapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NhaCungCapDAO nhaCungCapDao = new NhaCungCapDAO();
		ArrayList<NhaCungCap> tatCaNhaCungCap = nhaCungCapDao.tatCaNhaCungCap();
		request.setAttribute("tatCaNhaCungCap", tatCaNhaCungCap);
		RequestDispatcher dispatcher = this.getServletContext().
		getRequestDispatcher("/WEB-INF/views/nhacungcap.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
