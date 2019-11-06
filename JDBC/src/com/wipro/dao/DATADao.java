package com.wipro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.bean.Student;
import com.wipro.util.DBUtil;

public class DATADao {
 
  private static Connection connection= null;	
  private static PreparedStatement preparedStatement= null;
  private static String sql= null;
  private static ResultSet resultSet= null;
  private static Student student= null;
  
  public static int insert_data(Student student){
	  sql= "INSERT INTO student values(?,?,?)";
	  String sql_getID= "SELECT seq_id.nextval FROM dual";
	  int result= 0;
	  connection= DBUtil.getDBUtil();	
	  
	  try {  
	    preparedStatement= connection.prepareStatement(sql_getID);
	  
	    ResultSet set_id= preparedStatement.executeQuery();
	    String NEW_ID= null;  
	  
	  if(set_id.next()){
		  
		if(student.getSname().length()>=2){  
		 
			NEW_ID= String.valueOf(set_id.getInt(1))+student.getSname().substring(0,2);
		 
		}else{
			
			NEW_ID= String.valueOf(set_id.getInt(1))+student.getSname().charAt(0);
		}
		
		student.setSid(NEW_ID);
		
	  }
	  
		if(NEW_ID!= null){
		  
		  preparedStatement= connection.prepareStatement(sql);
		  preparedStatement.setString(1, NEW_ID);
		  preparedStatement.setString(2, student.getSname());
		  preparedStatement.setDate(3, student.getSdate());
		  
		  result= preparedStatement.executeUpdate();
		  
		}else{
			System.out.println("NULL Line Number 43");
		}
		
		preparedStatement.close();
		connection.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return result;
  }

  public static ArrayList<Student> getAllData() throws SQLException{
	  ArrayList<Student> studentList= new ArrayList<>();
	  
	  sql= "SELECT * FROM STUDENT";
	  connection= DBUtil.getDBUtil();	
	  
	  preparedStatement= connection.prepareStatement(sql);
      resultSet= preparedStatement.executeQuery();
      
      while(resultSet.next()){
    	   student= new Student();
    	   
    	   student.setSid(resultSet.getString("SID"));
    	   student.setSdate(resultSet.getDate("DOB"));
    	   student.setSname(resultSet.getString("SNAME"));
    	   
    	   studentList.add(student);
    	   
      }
  	preparedStatement.close();
	connection.close();
	  return studentList;
  }

  public static ArrayList<Student> getStudentFromID(String id) throws SQLException{
	  ArrayList<Student> arrayList= new ArrayList<>();
	  connection= DBUtil.getDBUtil();	
	  
	  sql= "SELECT * FROM STUDENT WHERE SID LIKE '%"+id+"%'";
	  preparedStatement= connection.prepareStatement(sql);
	  
	  resultSet= preparedStatement.executeQuery();
	  
	  while(resultSet.next()){
		  student= new Student();
		  
		  student.setSid(resultSet.getString("SID"));
		  student.setSname(resultSet.getString("SNAME"));
		  student.setSdate(resultSet.getDate("DOB"));
		  
		  arrayList.add(student);
	  }
		preparedStatement.close();
		connection.close();
	  return arrayList;
  }
}
