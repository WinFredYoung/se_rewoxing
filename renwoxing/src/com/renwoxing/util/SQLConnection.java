package com.renwoxing.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public abstract class SQLConnection {
	private static Connection connection = SQLConnectionDriver.connectionDateBase("root", "123456");
	public SQLConnection() {
		
	}
	public static Connection getConnection() throws SQLException {
		if(connection.isClosed()) {
			connection = SQLConnectionDriver.connectionDateBase("root", "123456");
		}
		return connection; 
	}
}
