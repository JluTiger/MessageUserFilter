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
 * �û���¼��ȫ���ƹ�����
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

		HttpServletRequest hrequest = (HttpServletRequest) request;// �漰��HTTP��������ת�ʹ���
		HttpServletResponse hresponse = (HttpServletResponse) response;// �漰��HTTP��������ת�ʹ���

		String loginUser = (String) hrequest.getSession().getAttribute("loginUser");// �ж��û��Ƿ�����˵�¼������session���Ƿ�洢�û���

		if (loginUser == null) {
			hresponse.sendRedirect(hrequest.getContextPath() + "/indext.jsp?flag=1");// δ��¼��ϵͳǿ���ض�������¼ҳ��
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