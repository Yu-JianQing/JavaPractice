package com.Web_2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AltSerclet extends HttpServlet{
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String name=req.getParameter("name");
	Student student=studentContent.map.get(name);
	
	if(student!=null){
		String sex=req.getParameter("sex");
		if(sex!=null&&"".equals(sex)){
			student.setSex(sex);
		}
		String pwd=req.getParameter("password");
		if(pwd!=null&&!"".equals(sex)){
			student.setPwd(pwd);
		}
		String[] hobbies=req.getParameterValues("hobbies");
		student.setHobbies(hobbies);
		String province=req.getParameter("province");
		student.setProvince(province);
		String info=req.getParameter("info");
		if(info!=null&&!"".equals(info)){
			student.setInfo(info);
		}
	}
	resp.sendRedirect("ALL.jsp");
	
//	req.getRequestDispatcher("ALL.jsp").forward(req, resp);
}

protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	doPost(req, resp);
}
}
