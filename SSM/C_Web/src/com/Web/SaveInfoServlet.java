package com.Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//doget方法，alt+/自动补全方法
public class SaveInfoServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)//resp参数用于写回信息
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");//设置响应回去的信息内容的字符编码格式，设置写回去（流）的时候的字符编码
		resp.setContentType("text/html;charset=utf-8");//设置返回内容类型及编码格式,通知浏览器服务器
		//返回的是text/HTML类型，编码是utf-8
		
		String name=req.getParameter("name");//参数为每个HTML页面中的name的值
		String pwd=req.getParameter("password");
		String province=req.getParameter("province");
		String sex=req.getParameter("sex");//ctrl+alt+向下箭头，向下复制一行
		String s[]=req.getParameterValues("habbies");
		
		System.out.println(111);
		PrintWriter pWriter=resp.getWriter();
		pWriter.println("<html>");
		pWriter.println("<head>");
		if("s".equals(name)){
			pWriter.println("<title>返回结果：error</title>");
			pWriter.println("<body>");
			pWriter.println("用户不能为s");
			pWriter.println("</body>");
		}else{
			pWriter.println("<title>返回结果：success</title>");
			pWriter.println("<body>");
			pWriter.println("处理完成："+new Date());
			pWriter.println("具体信息：");
			pWriter.println(name+"<br/>");
			pWriter.println(pwd+"<br/>");
			pWriter.println(province+"<br/>");
			sex="F".equals(sex)?"男":"女";
			pWriter.println(sex+"<br/>");
			pWriter.println("爱好为"+"<br/>");
			for(String s1:s){
				pWriter.println(s1);
			}
			pWriter.println("</body>");
		}
		
		pWriter.println("</head>");
		pWriter.println("<body>");
		pWriter.println("处理完成："+new Date());
		pWriter.println("</body>");
		pWriter.println("</html>");
		pWriter.flush();
		pWriter.close();
	}
/**
 * get请求调用doget
 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
