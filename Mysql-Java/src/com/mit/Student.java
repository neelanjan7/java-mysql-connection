package com.mit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	static String url="jdbc:mysql://localhost:3306/db_name";
    static String uname="user_name";
    static String password="password";
    static Connection con;
    static Scanner sc = new Scanner(System.in);
    
    static {
    	
    	try {
			con=DriverManager.getConnection(url, uname, password);
			System.out.println("Connection done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //****************************************************************************************************
    
    static void insert() throws SQLException
    {
    	String sql="insert into table_name values ( ?,?,?)";
    	PreparedStatement pst=con.prepareStatement(sql);
    	
    	System.out.println("Enter Student ID, Name and Marks");
    	
    	pst.setInt(1, sc.nextInt());
    	pst.setString(2, sc.next());
    	pst.setInt(3, sc.nextInt());
    	pst.execute();
    	System.out.println("Record is added");
    		
    }
    
   
    static void update () throws SQLException
    {
    	 String sql="update table_name set name= ?,marks=? Where id=?";
    	 PreparedStatement pst=con.prepareStatement(sql);
    	 System.out.println("Enter ID name and marks to update");
    	 
    	 pst.setInt(3, sc.nextInt());
     	pst.setString(1, sc.next());
     	pst.setInt(2, sc.nextInt());
    	 int z= pst.executeUpdate();
    	 if (z==1)
    	 System.out.println("updated");
    	 else System.out.println("Record not found");
    	 
    }
    
    static void delete () throws SQLException
    {
    	String sql = "Delete from table_name where id = ?";
    	PreparedStatement pst = con.prepareStatement(sql);
    	System.out.println("Enter Student ID to delete:");
    	pst.setInt(1, sc.nextInt());
    	int rows = pst.executeUpdate();
    	if (rows > 0) {
    	    System.out.println("Record deleted");
    	} else {
    	    System.out.println("No record found with that ID");
    	}

    }
    
    
    	
    public static void main(String[] args) throws SQLException {
    	update();
		
	}
    
}
