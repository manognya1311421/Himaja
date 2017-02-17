package com.mano;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","oracle");
		
		PreparedStatement pst = con.prepareStatement("insert into student values(?,?,?)");
		pst.setString(1, "soosi");
		pst.setString(2, "soosi@gmail.com");
		pst.setString(3, "Secunderabad");
		pst.executeUpdate();
		System.out.println("records inserted");
		
		//Statement st = con.createStatement();
		ResultSet rs = pst.executeQuery("select * from student");
		while(rs.next())
		{
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			
		}
		/*ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println(rsmd.getColumnName(column));*/
		System.out.println("working fine");
		con.close();
		
		}catch(Exception e){ System.out.println(e);}  
		}
	
		
		

	
	
}


