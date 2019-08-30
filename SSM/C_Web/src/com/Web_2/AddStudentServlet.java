package com.Web_2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddStudentServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");//getParameter获取参数用于在用表单或url重定向传值时接收数据
		String pwd=req.getParameter("password");
		String sex=req.getParameter("sex");
		String prov=req.getParameter("province");
		String[] hobbies=req.getParameterValues("hobbies");
		String info=req.getParameter("info");
		if(!"".equals(name.trim())&&name!=null){
			name=name.trim();
			Student student=studentContent.map.get(name);
			if(student!=null){
				req.setAttribute("message", "学生"+name+"姓名重复");//数据传递key-value形式
				req.getRequestDispatcher("addStudent.jsp").forward(req, resp);
			}else{//添加成功,并跳转到页面显示所有信息//重定向,发两次请求，浏览器地址会变成跳转到的路径地址
				//两次请求便有两个response，但第一个会丢失，若想不丢失，可以用session，他与response作用相同
				//方法类似，只不过比他作用范围更大
				HttpSession session=req.getSession();//每个request都存在session里
//				req.setAttribute("stus", studentContent.map);//不会起作用，因为request变了
				session.setAttribute("stus", studentContent.map.values());
				//getAttribute表示从request范围取得设置的属性,必须先set才能get，在这里也就是给session
				//设置相应属性，并且这些属性是以key-value的形式设置的，key可用于jsp中
				Student student2=new Student(name, pwd, sex, hobbies, prov, info);
				studentContent.map.put(name,student2);
				resp.sendRedirect("ALL.jsp");
			}
		}
		else{//跳转//服务器内部跳转，发一次请求,浏览器地址不会发生变化
			req.setAttribute("message", "学生姓名不能为空");//数据传递key-value形式
			req.getRequestDispatcher("addStudent.jsp").forward(req, resp);
		}
	}
}
