package com.wipro.service;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.bean.Student;
import com.wipro.dao.DATADao;

public class DataService {

	 private DATADao dao= new DATADao();
	
	 public void insert(Student student){
		 if(student!= null){
			 
			  int result= dao.insert_data(student);
			  if(result>0)
				   System.out.println("Data get Inserted !!");
			  else
				  System.out.println("Failed to insert Data !!");
		 }
	 }

     public ArrayList<Student> getAllRecord(){
    	 ArrayList<Student> getData= null;
    	 try{
    	   
    		 getData= dao.getAllData();
    	   
    	 }catch(SQLException sqlException){
    		 sqlException.printStackTrace();
    	 }
    	 return getData;
     }

     public ArrayList<Student> getSerchedIDS(String id){
    	 ArrayList<Student> arrayList= null;
    	 try{
    		 
    		 arrayList= dao.getStudentFromID(id);
    		 
    	 }catch(SQLException sqlException){
    		 sqlException.printStackTrace();
    	 }
    	 return arrayList;
     }
}
