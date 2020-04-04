package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Authentication
 */
@WebFilter({ "/home", "/ban-hang", "/danh-muc", "/don-vi", "/khach-hang", "/kho-hang", "/nha-cung-cap" 
	, "/sua-danh-muc", "/sua-don-vi", "/sua-khach-hang", "/sua-nha-cung-cap", "/sua-san-pham", "/sua-thuong-hieu"
	, "/nhan-vien", "/san-pham", "/them-danh-muc", "/them-don-vi", "/them-khach-hang", "/them-nha-cung-cap", "/them-nhan-vien"
	, "/them-san-pham", "/them-thuong-hieu", "/them-gio-hang", "/thuong-hieu", "/xoa-danh-muc", "/xoa-don-hang", "/xoa-don-vi"
	, "/xoa-khach-hang", "/xoa-nha-cung-cap", "/xoa-nhan-vien", "/xoa-san-pham", "/xoa-thuong-hieu", "/logout"})
public class Authentication implements Filter {

    /**
     * Default constructor. 
     */
    public Authentication() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession(false);
		if(session != null && session.getAttribute("username")!=null) {
			chain.doFilter(request, response);
		}else {
			RequestDispatcher dispatcher =
					httpReq.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
					dispatcher.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
