package com.Web_2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	doPost(req, resp);
}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name;
		for(Student student2:studentContent.map.values()){
			String string=student2.getName().trim();
			if(req.getParameter("name").equals(string)){
				name=student2.getName();
				studentContent.map.remove(name);
				break;
			}
		}
		
//		HttpSession session=req.getSession();
//		session.setAttribute("sts", studentContent.map.values());
//		resp.sendRedirect("ALL.jsp");
		req.getRequestDispatcher("ALL.jsp").forward(req, resp);
	}
}