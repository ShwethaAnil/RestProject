package com.mphasis.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//singleton DP
public class DbUtil {
	
	private static Connection con=null;
	private DbUtil() {
		
	}
	public static Connection openConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					 "java182", "java182");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
