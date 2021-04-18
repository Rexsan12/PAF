package model;

import java.sql.*;


public class Project {

	String pro_code;
	String pro_category;
	String pro_name;
	String pro_desc;
	String pro_price;
	String pro_count;
	
	
	public Connection connect()

	{ 
	 Connection con = null;

	 try
	 		{
		 	Class.forName("com.mysql.jdbc.Driver");
	 
		 	con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget","root", "");
	 
		 	//For testing
		 	
		 	System.out.print("Successfully connected");
	 		}
	 
	 	catch(Exception e)
	 	{
	 		e.printStackTrace();
	 	}

	 return con;

	 
	}


	public String insertProduct(String pro_code, String pro_category, String pro_name, String pro_desc, String pro_price, String pro_count) {
		
		String output = ""; 
		
		try {
		
				Connection con = connect();
				
				if (con == null)
					
				{
					return "Error while connecting to the database";
				}
		
		
				// create a prepared statement
		
				String query = " insert into products(`project_Id`,`project_code`,`project_category`,`project_name`,`project_descrip`,`project_price`,`no_of_projects`)" + " values (?, ?, ?, ?, ?, ?, ?)";
		
				PreparedStatement preparedStmt  = con.prepareStatement(query); 
		
				// binding values
		
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, pro_code);
				preparedStmt.setString(3, pro_category);
				preparedStmt.setString(4, pro_name);
				preparedStmt.setString(5, pro_desc);
				preparedStmt.setDouble(6, Double.parseDouble(pro_price)); 
				preparedStmt.setString(7, pro_count); 
			
		
				//execute the statement
		
				preparedStmt.execute();
				con.close();
				
				output = "Projects Inserted successfully";
		 }
		
		catch (Exception e)
		
		 {
				output = "Error while inserting the projects";
				
				System.err.println(e.getMessage());
		 }
		
		return output;	
		
	    } 


	public String readProducts()
	{
	 
			String output = "";
			
			try
			{
				
				Connection con = connect();
				
				if (con == null)		
				
			{
					return "Error while connecting to the database for reading.";
			}
				
				
	 // Prepare the html table to be displayed
				
	 output = "<table border='1'><tr><th>Project ID</th>"	 
			 +"<th>Project Code</th><th>Product Category</th>"	 
			 + "<th>Project Name</th>"
			 + "<th>Project Description</th>"
			 + "<th>Project Price</th>"
			 + "<th>Available Projects</th>"
			 + "<th>Update</th><th>Remove</th></tr>";
	 
	 	String query = "select * from products";
	 	Statement stmt = con.createStatement();
	 	ResultSet rs = stmt.executeQuery(query); 
	 	
	 // iterate through the rows in the result set
	 	
	 
	 	while (rs.next())
	 
	 	{
	 		
	 		String project_Id = Integer.toString(rs.getInt("project_Id"));
	 		String project_code = rs.getString("project_code");
	 		String project_category = rs.getString("project_category");
	 		String project_name = rs.getString("project_name");
	 		String project_descrip = rs.getString("project_descrip");
	 		String project_price = Double.toString(rs.getDouble("project_price"));
	 		String no_of_projects = Integer.toString(rs.getInt("no_of_projects"));     
	 		
	 		
	 // Add a row into the html table
	 		
	 		output += "<tr><td>" + project_Id + "</td>";
	 		output += "<td>" + project_code + "</td>";
	 		output += "<td>" + project_category + "</td>";
	 		output += "<td>" + project_name + "</td>"; 
	 		output += "<td>" + project_descrip + "</td>";
	 		output += "<td>" + project_price + "</td>";
	 		output += "<td>" + no_of_projects + "</td>";
	 // buttons
	 		
	   output
			  += "<td><input name='btnUpdate' "
			  + " type='button' value='Update' class='btn btn-secondary' </td>"
	 		  + "<td><form method='post' action='Products.jsp'>"
	 		  + "<input name='btnRemove' " + " type='submit' value='Remove' class='btn btn-danger'>"
	 		  + "<input name='project_Id' type='hidden' " + " value='" + project_Id + "'>" + "</form></td></tr>";
	 		 
	 
	 }	 	
		 	
	 con.close();
	 
	 // Complete the html table
	 
	       output += "</table>";
	 }
	catch (Exception e)
	 {
	 output = "Error while reading the products.";
	 
	 System.err.println(e.getMessage());
	 }
			
	return output;

	}


	public String deleteProduct(String project_Id)

		{
			String output = "";

			try
			{
				
				Connection con = connect();
				
				if (con == null)
					
			{
					
					return "Error while connecting to the database for deleting.";
			}
				
	 // create a prepared statement
				
				String query = "delete from products where project_Id=?";
				
				PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
				
				preparedStmt.setInt(1, Integer.parseInt(project_Id));

	 // execute the statement
				
				preparedStmt.execute();
				con.close();
				
				output = "Deleted successfully";
			}
			
			catch (Exception e)
			{
				output = "Error while deleting the project.";
				System.err.println(e.getMessage());
			}
			
			return output;
	}
	



public String updateProduct(String pro_Id, String pro_code, String pro_category, String pro_name, String pro_desc, String pro_price, String pro_count) {
	
	String output = "";
	try
		 {
		 Connection con = connect();
		 if (con == null)
		 {
			 return "Error while connecting to the database";
		 }
		 
		// create a prepared statement
		 String query = "UPDATE products SET project_code=?,project_category=?,project_name=?,project_descrip=?,project_price=?,no_of_projects=? WHERE project_Id=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query);
 
		// binding values
		 
			preparedStmt.setString(1, pro_code);
			preparedStmt.setString(2, pro_category);
			preparedStmt.setString(3, pro_name);
			preparedStmt.setString(4, pro_desc);
			preparedStmt.setDouble(5, Double.parseDouble(pro_price)); 
			preparedStmt.setString(6, pro_count);
		    preparedStmt.setInt(7, Integer.parseInt(pro_Id)); 

		 
		 //execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Updated successfully";
		 
		 }
	catch (Exception e)
	 {
	 output = "Error while updating the project.";
	 System.err.println(e.getMessage());
	 }
	return output;
}
	
	
}
