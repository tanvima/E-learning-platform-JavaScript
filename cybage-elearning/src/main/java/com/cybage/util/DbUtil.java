package com.cybage.util;

	import java.io.FileReader;
	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

	import org.apache.commons.dbcp2.BasicDataSource;

	public class DbUtil  {

		
		private static  String dbUrl;
		private static  String dbUser; 
		private static  String dbPassword;
		static {   
			FileReader fr;
			try {
				fr = new FileReader("d://db.properties");
				Properties props = new Properties();
				props.load(fr);
				dbUrl = props.getProperty("dbUrl");
				dbUser = props.getProperty("dbUser");
				dbPassword = props.getProperty("dbPassword");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public  static Connection getCon() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		System.out.println("JDBC Connection error");
			e.printStackTrace();
		} 
				
				
				Connection con
				= DriverManager.getConnection(dbUrl,dbUser,dbPassword);
				return con;
		}	
		
	
//	public static Connection getCon() throws Exception{
//			
//			BasicDataSource ds = new BasicDataSource();
//			ds.setUrl(dbUrl);
//			ds.setUsername(dbUser);
//			ds.setPassword(dbPassword);
//			ds.setMinIdle(5);
//			ds.setMaxIdle(10);
//			ds.setMaxOpenPreparedStatements(100);
//			return ds.getConnection();
//		}

	}

