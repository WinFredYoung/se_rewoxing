package com.renwoxing.util;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class SQLConnectionDriver {
	private SQLConnectionDriver() {
		
	}
	
	public static Connection connetcionDateBase(String url, String userName, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		Connection connection = null;
		try {
			connection = (Connection)DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return connection;
	}
	
	public static Connection connectionDateBase(String userName,String password) {
		
		String url = "jdbc:mysql://localhost:3306/rwx?characterEncoding=utf-8";
		return connetcionDateBase(url, userName, password);
	}
	
	
	
}
