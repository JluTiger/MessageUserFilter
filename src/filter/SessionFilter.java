package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录安全控制过滤器
 * 
 * @author lv
 *
 */
public class SessionFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest hrequest = (HttpServletRequest) request;// 涉及到HTTP请求处理，转型处理
		HttpServletResponse hresponse = (HttpServletResponse) response;// 涉及到HTTP请求处理，转型处理

		String loginUser = (String) hrequest.getSession().getAttribute("loginUser");// 判断用户是否完成了登录操作，session中是否存储用户名

		if (loginUser == null) {
			hresponse.sendRedirect(hrequest.getContextPath() + "/indext.jsp?flag=1");// 未登录，系统强制重定向至登录页面
			return;
		} else {
			chain.doFilter(hrequest, hresponse);
			return;
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
