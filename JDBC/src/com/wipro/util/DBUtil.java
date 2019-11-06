package com.wipro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
  
  private static Connection connect= null;
  private static PreparedStatement preparedStatement= null;
  
  public static Connection getDBUtil(){
	  
	 try{ 
	  
		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     connect= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr"); 
	  
	 }catch(SQLException sqlException){
		 sqlException.printStackTrace();
	 }catch(ClassNotFoundException classNotFoundException){
		 classNotFoundException.printStackTrace();
	 }
	  
	  return connect;
  }
}
