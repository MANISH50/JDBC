package com.wipro.controller;

import java.sql.Date;

import com.wipro.bean.Student;
import com.wipro.service.DataService;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	
	private static DataService dataService= new DataService();
	private static int option= 0;
	private static boolean is_more= true;
	private static Scanner scanner= new Scanner(System.in);
	private static Student student= new Student();
	private static ArrayList<Student> getAllData= new ArrayList<>();
	
 public static void main(String...manish) throws IOException{
	  
	 while(is_more){
	   displayOption();
	   System.out.println("\nSelect anyn one option: ");
	   option= scanner.nextInt();
	   
	    switch(option){
	    case 1:
	    	System.out.print("Name: ");
	    	student.setSname( new BufferedReader(new InputStreamReader(System.in)).readLine() );
	    	
	    	System.out.print("DOB: ");
	    	student.setSdate(Date.valueOf( new BufferedReader(new InputStreamReader(System.in)).readLine()  ));
	    	
	    	dataService.insert(student);
	    	break;
	    	
	    case 2:
	    	
	    	 getAllData= dataService.getAllRecord();
	    	 
	    	 for(Student stu: getAllData){
	    		 System.out.println("ID: "+stu.getSid()+"\nName: "+stu.getSname()+"\nDOB: "+stu.getSdate());
	    		 System.out.println("-----------------------------");
	    	 }
	    	 
	    	break;
	    case 4:
	    	 System.out.print("Get Student From ID: ");
	    	 getAllData= dataService.getSerchedIDS( new BufferedReader( new InputStreamReader(System.in) ).readLine() );
	    	
	    	 if(getAllData.size()>0){
	    	  for(Student stu: getAllData){
	    		 System.out.println("ID: "+stu.getSid()+"\nName: "+stu.getSname()+"\nDOB: "+stu.getSdate());
	    		 System.out.println("-----------------------------");
	    	  }
	    	}else{
	    		System.out.println("\nData Not Found !!");
	    	}
	    	 
	    	break; 
	    }
	    
	    System.out.println("\nEnter More: (yes/no)");
	    String more= new BufferedReader( new InputStreamReader(System.in)).readLine();
	    
	     if(!more.equalsIgnoreCase("yes"))
	    	  is_more= false;
	    
	 }
	 
 }
 private static void displayOption(){
	 System.out.println("\nSelect any one Option: \n1.Insert Data\n2.Display All Data"
	 		+ "\n3.Update Data\n4.Find Particular Student.");
 }
}
