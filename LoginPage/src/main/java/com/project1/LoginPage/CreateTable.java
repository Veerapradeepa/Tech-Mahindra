package com.project1.LoginPage;

import java.sql.*;

public class CreateTable 
{
	public static void main(String args[])
	{
		String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
	    String username = "PRADEEPA";
		String password = "1234";
		
		try {
	    	//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	    	Class.forName ("oracle.jdbc.driver.OracleDriver");
	    	Connection con = DriverManager.getConnection (dbURL,username,password);
	         Statement st = con.createStatement();
	         String sql = "CREATE TABLE PRADEEPA.LOGIN_CREDENTIALS"+"(USER_NAME VARCHAR(20),"+"PASSWORD VARCHAR(20))";
	         
	         st.executeUpdate(sql);
	         System.out.println("Created table in given database..."); 
             con.close();
	         }
	    catch(Exception e){
	    	System.out.println(e);
	    }
	}
	

}
