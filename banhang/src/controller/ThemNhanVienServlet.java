package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.User;
import dao.UserDAO;

/**
 * Servlet implementation class ThemNhanVienServlet
 */
@WebServlet(name = "them-nhan-vien", urlPatterns = { "/them-nhan-vien" })
public class ThemNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemNhanVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/themnhanvien.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = (String) request.getParameter("username");
		String passWord = (String) request.getParameter("password");
		String hoTen = (String) request.getParameter("hoten");
		String roleT = (String) request.getParameter("chucvu");
		String ngaySinh = (String) request.getParameter("ngaysinh");
		String cmnd = (String) request.getParameter("cmnd");
		String dienThoai = (String) request.getParameter("dienthoai");
		String email = (String) request.getParameter("email");
		String role ="0";
		String chucVu = (String) request.getParameter("chucvu");
		if(roleT.equals("Quản Trị")) {
			role="1";
			
		}else {
			role="0";
		}
		UserDAO userDao =  new UserDAO();
		if(userDao.findUser(userName)) {
			String thongBao = "<div class='thongbao'>Tài khoản đã tồn tại</div>";
			request.setAttribute("thongbao", thongBao);
			RequestDispatcher dispatcher =
					this.getServletContext().getRequestDispatcher("/WEB-INF/views/themnhanvien.jsp");
					dispatcher.forward(request, response);
		}else {
			String thongBao = "<div class='thongbao'>Đã tạo user thành công</div>";
			request.setAttribute("thongbao", thongBao);
			User newUser = new User();
			newUser.setUserName(userName);
			newUser.setPassWord(passWord);
			newUser.setHoten(hoTen);
			newUser.setRole(role);
			newUser.setNgaySinh(ngaySinh);
			newUser.setCMND(cmnd);
			newUser.setDienThoai(dienThoai);
			newUser.setEmail(email);
			newUser.setChucVu(chucVu);
			userDao.themUser(newUser);
		}
		RequestDispatcher dispatcher =
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/themnhanvien.jsp");
				dispatcher.forward(request, response);
	}

}
