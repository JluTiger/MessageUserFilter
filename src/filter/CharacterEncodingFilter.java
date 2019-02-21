package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	
	private FilterConfig config;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//System.out.println("¹ýÂËÆ÷Ïú»Ù...");
		
		

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//System.out.println("¹ýÂËÆ÷doFilter...");
		//String systemName=config.getInitParameter("systemName");
		//String version=config.getInitParameter("version");
		//System.out.println("SystemName:"+systemName);
		//System.out.println("Version:"+version);
		
		request.setCharacterEncoding(config.getInitParameter("charset"));
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config=config;
	}

	public FilterConfig getConfig() {
		return config;
	}

	public void setConfig(FilterConfig config) {
		this.config = config;
	}

}
