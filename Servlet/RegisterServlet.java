package com.servlet;

import java.io.IOException;

import com.conn.DbConnect;
import com.dao.UserDAO;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		User u=new User(name,email,password);
		
		UserDAO dao=new UserDAO(DbConnect.getConn());
		boolean f=dao.userRegister(u);
		
		HttpSession session=request.getSession();
		
		if(f) {
			session.setAttribute("sucssMsg", "User Register Successfully");
			response.sendRedirect("register.jsp");
			//System.out.println("User Registered Successfully");
		}
		else {
			session.setAttribute("errorMsg", "Something wrong on server");
			response.sendRedirect("register.jsp");
			System.out.println("Something wrong on server");
		}
		
	}
}
