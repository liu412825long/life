package cn.sh.life.etc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sh.life.etc.util.LoginCookieUtils;

public class SystemFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy  Filter");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		Integer userId = LoginCookieUtils.getUserAccountIdFromCookie(request);
		String url = request.getRequestURI();
		this.getRequestInfo(request);
		if (url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".jpg") || url.endsWith("/index")
				|| url.endsWith("/page/register") || url.endsWith("/loginAccount")
				|| url.endsWith("/registerAccount")) {
			arg2.doFilter(request, response);
		} else {
			if (userId != null) {
				arg2.doFilter(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/index");
			}

		}

	}

	private void getRequestInfo(HttpServletRequest request) {
		String str1 = request.getContextPath();
		String str2 = request.getMethod();
		String str3 = request.getRequestURI();
		String str4 = request.getRequestURL().toString();
		String str5 = request.getServletContext().getContextPath();
		System.out.println(str1 + "..." + str2 + "...." + str3 + ".." + str4 + "..." + str5 + "...");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init Filter");

	}

}
