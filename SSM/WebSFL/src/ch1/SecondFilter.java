package ch1;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/SecondFilter")
public class SecondFilter implements Filter {

	public void destroy() {
		System.out.println("the SecondFilter filter is destroyed");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("SecondFilter start");
		chain.doFilter(request, response);
		System.out.println("SecondFilter end");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("SecondFilter init");
	}

}
