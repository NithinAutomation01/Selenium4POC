package utils;

import java.sql.*;

public class MySqlConnection {

	public static Connection mysql() throws Exception{
	                                           
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/testdB","root","root"); 
		return con;
		
	}
}
