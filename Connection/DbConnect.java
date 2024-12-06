package com.conn;
import java.sql.*;

public class DbConnect {
	private  static Connection conn;
	
	public static Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook","root","Sri2003@");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
