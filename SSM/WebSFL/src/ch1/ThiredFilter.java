package ch1;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/ThiredFilter")
public class ThiredFilter implements Filter {

	public void destroy() {
		System.out.println("the ThiredFilter filter is destroyed");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("ThiredFilter start");
//		chain.doFilter(request, response);
		System.out.println("ThiredFilter end");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("ThiredFilter init");
	}

}
