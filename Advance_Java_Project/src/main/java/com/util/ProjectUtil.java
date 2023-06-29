package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProjectUtil {

	public static Connection createConnection()
	{
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mwf_5","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
