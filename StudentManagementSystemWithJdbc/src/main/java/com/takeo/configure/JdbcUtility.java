package com.takeo.configure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtility {
	
	private static Connection con=null;
	
	public static Connection getConnection() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException
	{
		Properties pro=new Properties();
		
		pro.load(new FileInputStream("C:\\Users\\Pravin\\eclipse-workspace\\CorejJava\\StudentManagementSystemWithJdbc\\src\\main\\java\\com\\takeo\\properties\\app.properties"));
		
		//step 1: We need to register a Driver which we have already initialized in properties
		Class.forName(pro.getProperty("dbClass"));
		
		//Step 2: Create a connection with url, uname, and password from properties
		
		con=DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("dbUname"), pro.getProperty("dbPassword"));
		
		
		return con;
		
	}
	
	public static void closeConnection(Connection con, PreparedStatement ps) throws SQLException
	{
		if(con !=null)
		con.close();
		
		if(ps !=null)
			ps.close();
	}
	
	public static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException
	{
		if(con !=null)
			con.close();
		
		if(ps !=null)
			ps.close();
		
		if(rs !=null)
			rs.close();
		
	}

}
