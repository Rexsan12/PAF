package model;

import java.sql.*; 

public class Sponsor {

	
	

	public  Connection connect() { 
		
		Connection con = null;
		
		try {
		 
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gadgetbadget? useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		 	//System.out.print("connected");
	 		
		}
	 
	 	catch(Exception e) {
	 		
	 		e.printStackTrace();
	 		//System.out.print("not connected");
	 		}

		return con;

	 
	}
	


	// ********************************************************insert*********************************************************************************
	 
	public String insertItem(String fname, String lname, String company, String job, String phone, String mail, String city) { 
		
		String output = ""; 
	 
		try { 
			Connection con = connect();
	  
			if (con == null) {
				return "Error while connecting to the database for inserting."; 
			} 
	 
			String query = " insert into sponsor (`buyer_id`, `f_name`,`l_name`,`company`,`job`,`phone`,`mail`,`city`)" + " values (?, ?, ?, ?, ?, ?, ?, ?)"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
			
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, fname); 
			preparedStmt.setString(3, lname); 
			preparedStmt.setString(4, company); 
			preparedStmt.setString(5, job); 
			preparedStmt.setString(6, phone); 
			preparedStmt.setString(7, mail); 
			preparedStmt.setString(8, city); 
	 
	
			preparedStmt.execute(); 
			con.close(); 
	 
			output = "Inserted successfully"; 
		} 
		catch (Exception e) 
		{ 
			output = "Error while inserting the item."; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	 } 
//*********************************************************************************************************************************************************	
	
	
	
	
	
	
	
	
	
	
//*************************************************************read***************************************************************************************
	
	public String readItems() 
	 { 
		String output = ""; 
		
		try
		{ 
			Connection con = connect(); 
			if (con == null) {
				return "Error while connecting to the database for reading.";
				} 
	
			output = "<table border='1'> <tr><th>Buyer ID</th>"
					+ "<th>First Name</th>"
					+ "<th>Last Name</th>"
					+ "<th>Company</th>"
					+ "<th>Job Title</th>"
					+ "<th>Contact No</th>"
					+ "<th>Email</th>"
					+ "<th>City</th></tr>"; 
	 
			String query = "select * from sponsor"; 
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery(query); 
	 
	 
	
			while (rs.next()) 
			{ 
		 
				String buyer_id = Integer.toString(rs.getInt("buyer_id")); 
				String f_name = rs.getString("f_name"); 
				String l_name = rs.getString("l_name"); 
				String company = rs.getString("company"); 
				String job = rs.getString("job"); 
				String phone = rs.getString("phone"); 
				String mail = rs.getString("mail"); 
				String city = rs.getString("city"); 
	 
	
				output += "<tr><td>" + buyer_id + "</td>";
				output += "<td>" + f_name + "</td>";
				output += "<td>" + l_name + "</td>"; 
				output += "<td>" + company + "</td>"; 
				output += "<td>" + job + "</td>"; 
				output += "<td>" + phone + "</td>"; 
				output += "<td>" + mail + "</td>"; 
				output += "<td>" + city + "</td>"; 
	 
	 // buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
						+ "<td><form method='post' action='index.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
						+ "<input name='buyer' type='hidden' value=' "+ buyer_id+ "\"> </form></td></tr>"; 
			} 
			
	 con.close(); 
	 
	// Complete the html table
	 output += "</table>"; 
	 } 
	 catch (Exception e) 
	 { 
		 output = "Error while reading the items."; 
		 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	
	
//***************************************************************************************************************************************************************	
	
	
	
	
	
	
	
	
	
//************************************************************update********************************************************************************************
	
	public String updateItem(String ID, String fname, String lname, String company, String job, String phone, String mail, String city)
	 {
		
	 String output = "";
	 
	 try
	 {
		 Connection con = connect();
		 
		 if (con == null) {
			 
			 return "Error while connecting to the database for updating.";
			 }
	 
		 String query = "UPDATE sponsor SET f_name=?, l_name=?, company=?, job=?, phone=?, mail=?, city=? WHERE buyer_id=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);

		 preparedStmt.setString(1, fname); 
		 preparedStmt.setString(2, lname); 
		 preparedStmt.setString(3, company); 
		 preparedStmt.setString(4, job); 
		 preparedStmt.setString(5, phone); 
		 preparedStmt.setString(6, mail); 
		 preparedStmt.setString(7, city);;
		 preparedStmt.setInt(8, Integer.parseInt(ID));
	
		 preparedStmt.execute();
		 con.close();
		 
		 output = "Updated successfully";
		 
	 }
	 catch (Exception e){
		 
		 output = "Error while updating the item.";
		 System.err.println(e.getMessage());
	 
	 }
	 return output;
	 } 
	
	
//***************************************************************************************************************************************	
	
	
	
	
	
	
	
//**************************************************************delete*****************************************************************
	
	public String deleteItem(String buyer_id)
	 {
	 
		String output = "";
		
		try{
			
			Connection con = connect();
			if (con == null){
				return "Error while connecting to the database for deleting.";
				}
	 
			String query = "delete from sponsor where buyer_id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);


			preparedStmt.setInt(1, Integer.parseInt(buyer_id));
			
			preparedStmt.execute();
			con.close();
			
			output = "Deleted successfully";
		}
	 catch (Exception e) {
		 
		 output = "Error while deleting the item.";
		 System.err.println(e.getMessage());
	 }
		
	 return output;
	 
	 }
	 
}
