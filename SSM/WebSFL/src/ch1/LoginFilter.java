package ch1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String filterName=filterConfig.getFilterName();
		System.out.println("filter init && name = "+filterName);
		String value=filterConfig.getInitParameter("key");
		System.out.println("filter init key=key,value= "+value);
		System.out.println("LoginFilter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("loginfilter start(filter first)");
		String address=request.getRemoteAddr();
		System.out.println("the remote address :"+address);
		
		//请求到达dofilter时就会直接转发不会执行后面的语句
		chain.doFilter(request, response);//doFilter有点像请求转发，也是只能转发一次。如果有n个filter则写n-1个
				//dofilter最后一个拦截器中不用写，它会自动返回。如果写了所有的Filter就会再执行一遍
		//当filter链都执行完后再按照队列的方式依次返回，如果成功就将请求转发到请求资源的哪里，如果失败就会抛出异常
		System.out.println("loginfilter end");
//		PrintWriter out=response.getWriter();
//		out.print("55555555555");
	}

	@Override
	public void destroy() {
		System.out.println("the LoginFilter filter is destroyed");
	}

}
