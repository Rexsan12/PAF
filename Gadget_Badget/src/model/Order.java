package model;

import java.sql.*;
import java.sql.Connection;


public class Order {
	
	//A common method to connect to the DB
	private Connection connect() 
	 { 
	 Connection con = null; 
	 try
	 { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 
	 //Provide the correct details: DBServer/DBName, username, password 
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget", "root", ""); 
	 System.out.println("Successfully Connected");
	 } 
	 catch (Exception e) 
	 {
		 e.printStackTrace();
	 } 
	 return con; 
	 } 
	
	public String insertOrder(String project_id, String project_name, String sponsor, String budget) 
	{ 
		String output = ""; 
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{
				return "Error while connecting to the database for inserting.";
				}
			
			// create a prepared statement
			String query = " insert into orders (Order_ID,Order_date,Project_ID,Project_name,Sponsor,Budget)" + " values (?, ?, ?, ?, ?, ?)"; 
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(3, project_id);
			preparedStmt.setString(4, project_name);
			preparedStmt.setString(5, sponsor);
			preparedStmt.setDouble(6, Double.parseDouble(budget)); 
	 
			// execute the statement
			preparedStmt.execute(); 
			con.close(); 
			output = "Inserted successfully";
			} 
		catch (Exception e) 
		{ 
			output = "Error while inserting the order details."; 
			System.err.println(e.getMessage()); 
			} 
		return output; 
		} 
	
	public String readOrders() 
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
			output = "<table border='1'><tr><th>Item Code</th><th>Item Name</th>" + 
			"<th>Item Price</th>" + "<th>Item Description</th>" + "<th>Update</th><th>Remove</th></tr>"; 
			String query = "select * from rough"; 
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next()) 
			{ 
				String orderID = Integer.toString(rs.getInt("Order_ID")); 
				String project_id = rs.getString("Project_ID"); 
				String project_name = rs.getString("Project_name");
				String researcher = rs.getString("Researcher_Name");
				String sponsor = rs.getString("Sponsor");
				String budget = Double.toString(rs.getDouble("Budget")); 
				String subject = rs.getString("Subject");
				
				// Add into the html table
				output += "<tr><td>" + project_id + "</td>"; 
				output += "<td>" + project_name + "</td>";
				output += "<td>" + researcher + "</td>"; 
				output += "<td>" + sponsor + "</td>";
				output += "<td>" + budget + "</td>"; 
				output += "<td>" + subject + "</td>";
				
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>" 
				+ "<td><form method='post' action='items.jsp'>" 
						+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>" 
				+ "<input name='itemID' type='hidden' value='" + orderID  
				+ "'>" + "</form></td></tr>";
				
			} 
	 con.close(); 
	 // Complete the html table
	 output += "</table>"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while reading the order details."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	
	public String updateOrder(String orderID, String project_id, String project_name, String sponsor, String budget)
	{
		String output = ""; 
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{
				return "Error while connecting to the database for updating.";
			} 
			
			// create a prepared statement
			String query = "UPDATE orders SET Project_ID=?,Project_name=?,Sponsor=?,Budget=? WHERE Order_ID=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setString(1, project_id);
			preparedStmt.setString(2, project_name);
			preparedStmt.setString(3, sponsor);
			preparedStmt.setDouble(4, Double.parseDouble(budget));
			preparedStmt.setInt(5, Integer.parseInt(orderID));
			
			// execute the statement
			preparedStmt.execute(); 
			con.close(); 
			output = "Updated successfully";
			
		 } 
		 catch (Exception e) 
		 { 
			 output = "Error while updating the order details."; 
			 System.err.println(e.getMessage()); 
		 } 
		
		return output;
    } 
	
		public String deleteOrder(String orderID) 
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
				String query = "delete from rough where orderID=?"; 
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(orderID));
				
				// execute the statement
				preparedStmt.execute(); 
				con.close(); 
				output = "Deleted successfully"; 
					
			} 
			catch (Exception e) 
			{ 
				output = "Error while deleting the order details."; 
				System.err.println(e.getMessage()); 
			} 
			
			return output; 
		 } 
}
