package com.mit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    	System.out.println("Enter Student ID:");
    	int id = sc.nextInt();
    	String checkSql = "SELECT id FROM Table_name WHERE id = ?";
    	PreparedStatement checkPst = con.prepareStatement(checkSql);

    	checkPst.setInt(1, id);

    	ResultSet rs = checkPst.executeQuery();
    	
    	if (rs.next()) {

    	  
    	    System.out.println("Enter new name:");
    	    String name = sc.next();

    	    System.out.println("Enter new marks:");
    	    int marks = sc.nextInt();

    	    String updateSql = "UPDATE Table_name SET name = ?, marks = ? WHERE id = ?";
    	    PreparedStatement updatePst = con.prepareStatement(updateSql);

    	    updatePst.setString(1, name);
    	    updatePst.setInt(2, marks);
    	    updatePst.setInt(3, id);

    	    updatePst.executeUpdate();
    	    System.out.println("Record updated successfully");

    	} else {
    	    System.out.println("Record not found");
    	}

    	 
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


