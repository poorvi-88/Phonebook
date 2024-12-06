package com.servlet;
import java.io.IOException;

import com.conn.DbConnect;
import com.dao.UserDAO;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		System.out.println(email+" "+pass);
		
		UserDAO dao=new UserDAO(DbConnect.getConn());
		User u=dao.loginUser(email, pass);
		HttpSession session=req.getSession();
		if(u!=null) {
			session.setAttribute("user",u);
			resp.sendRedirect("index.jsp");
			//System.out.println("User Is Available="+u);
		}
		else {
			session.setAttribute("invalidMsg","Invalid Email and Password");
			resp.sendRedirect("login.jsp");
			//System.out.println("User Is Not Available="+u);
		}
		
	}
	
	
}
