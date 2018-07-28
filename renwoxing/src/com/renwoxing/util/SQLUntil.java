package com.renwoxing.util;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;



public class SQLUntil {
	public static ResultSet getResultSet(String sql,Connection connection) {
//		Connection connection = SQLConnectionDriver.connectionDateBase("root", "jinhongjian123");
		Statement statement = null;
		try {
			statement = (Statement) connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return resultSet;
	}
}
