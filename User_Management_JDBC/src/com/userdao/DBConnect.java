package com.userdao;

import java.sql.*;
import java.io.*;

public class DBConnect {
	public static Connection getConnect() throws ClassNotFoundException,SQLException {
		Connection con = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/UserManage";
		con = DriverManager.getConnection(url,"root","");
		
		return con;
	}
}
