package test;

import java.sql.*;

import utils.MySqlConnection;  
public class MysqlValidation {

	public static void main(String args[]) throws Exception
	{

		Connection con=MySqlConnection.mysql();


		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select count(*) from  adidas_sales");  
		while(rs.next())  {
			System.out.println(rs.getInt(1));  

	}  con.close();



	}
}
