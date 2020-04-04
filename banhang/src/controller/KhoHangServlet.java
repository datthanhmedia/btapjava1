package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.KhoHang;
import bo.SanPham;
import dao.KhoHangDAO;
import dao.SanPhamDAO;

/**
 * Servlet implementation class KhoHangServlet
 */
@WebServlet(name = "kho-hang", urlPatterns = { "/kho-hang" })
public class KhoHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhoHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KhoHangDAO khoHangDao = new KhoHangDAO();
		ArrayList<KhoHang> khoHang1 = khoHangDao.tatCaKhoHang();
	
		ArrayList<KhoHang> khoHang = new ArrayList<KhoHang>();
		SanPhamDAO spdao = new SanPhamDAO();
		for (int i = 0; i < khoHang1.size(); i++) {
			
			SanPham sp = spdao.getSanPham(khoHang1.get(i).getMaSanPham());
			khoHang1.get(i).setMaVach(sp.getMaVach());
			khoHang1.get(i).setTenSanPham(sp.getTenSanPham());
			khoHang1.get(i).setGiaVon(sp.getGiaVon());
			khoHang1.get(i).setGiaBan(sp.getGiaBan());
			khoHang1.get(i).setGiaBuon(sp.getGiaBuon());
			
			khoHang1.get(i).setVat(sp.getVat());
			khoHang.add(khoHang1.get(i));
		}
		request.setAttribute("khoHang", khoHang);
		
		
		RequestDispatcher dispatcher = this.getServletContext().
		getRequestDispatcher("/WEB-INF/views/khohang.jsp");
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
