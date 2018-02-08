import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

//import com.mysql.jdbc.PreparedStatement;

public class Employee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		Statement stmt = null;
		//Connection conn1=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			 conn=DriverManager.getConnection("jdbc:mysql://localhost/","root","Welcome123");
		
		System.out.println("Creating database...");
	      stmt = conn.createStatement();
	      
	      String sql = "CREATE DATABASE Employee";
	      stmt.executeUpdate(sql);
	      System.out.println("Database created successfully...");
		}
	   catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	        
			if(conn!=null)
	            stmt.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
		/*try
		{
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","Welcome123");
		System.out.println("Creating table in given database...");
	      stmt = conn.createStatement();
	      
	      String sql = "CREATE TABLE student_details " +
	                   "(id INTEGER not NULL, " +
	                   " first_name VARCHAR(255), " + 
	                   " last_name VARCHAR(255), " + 
	                    "dept integer,"+
	                   " PRIMARY KEY ( id ))"; 

	      stmt.executeUpdate(sql);
	      System.out.println("Created table in given database...");
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	  // System.out.println("Goodbye!");
	   try
	   {
		   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","Welcome123");
		   System.out.println("Inserting records into the table...");
		      stmt = conn.createStatement();
		      
		      String sql = "INSERT INTO emp_details " +
		                   "VALUES (100, 'Zara', 'Ali', 18000,001)";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO emp_details " +
		                   "VALUES (101, 'Mahnaz', 'Fatma', 25000,002)";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO emp_details " +
		                   "VALUES (102, 'Zaid', 'Khan', 30000,003)";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO emp_details " +
		                   "VALUES(103, 'Sumit', 'Mittal', 28000,004)";
		      stmt.executeUpdate(sql);
		      System.out.println("Inserted records into the table...");

		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		  // System.out.println("Goodbye!");
		
		try
		{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","Welcome123");
			//conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","Welcome123");
			System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql = "UPDATE emp_details " +
		                   "SET salary = 30000 WHERE id in (100, 101)";
		      stmt.executeUpdate(sql);

		      // Now you can extract all the records
		      // to see the updated records
		      sql = "SELECT id, first_name, last_name, salary,dept FROM emp_details";
		      ResultSet rs = stmt.executeQuery(sql);

		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int salary = rs.getInt("salary");
		         String first_name = rs.getString("first_name");
		         String last_name = rs.getString("last_name");
		         int dept=rs.getInt("dept");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", salary: " + salary);
		         System.out.print(", First_name: " + first_name);
		         System.out.println(", Last_name: " + last_name);
		         System.out.println(", dept: " + dept);
		      }
		      rs.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		
		try
		{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","Welcome123");
			System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql = "DELETE FROM emp_details " +
		                   "WHERE id = 101";
		      stmt.executeUpdate(sql);

		      // Now you can extract all the records
		      // to see the remaining records
		      sql = "SELECT id, first_name, last_name, salary,dept FROM emp_details";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
			         //Retrieve by column name
			         int id  = rs.getInt("id");
			         int salary = rs.getInt("salary");
			         String first_name = rs.getString("first_name");
			         String last_name = rs.getString("last_name");
			         int dept=rs.getInt("dept");

			         //Display values
			         System.out.print("ID: " + id);
			         System.out.print(", salary: " + salary);
			         System.out.print(", First_name: " + first_name);
			         System.out.println(", Last_name: " + last_name);
			         System.out.println(", dept: " + dept);
		      
		      }
		      rs.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");*/
		}
		}
		
		 
		
	

	


