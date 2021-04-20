package model;

import java.sql.*;

public class Researcher {

	public Connection connect(){
		Connection con = null;
	 try
	 {
	       Class.forName("com.mysql.cj.jdbc.Driver");
	       //Provide the correct details: DBServer/DBName, username, password
	       con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget","root", "");
	       
	       //For testing
	       System.out.print("Successfully connected");
	 }
	 catch(Exception e){

	    e.printStackTrace();
	 }
	 return con;
	}
	
public String insertResearcher(String resCode, String resName, String resProjCode, String resEmail, String resLocation){
	    
	    String output = "";
		
		try{
	         Connection con = connect();
	         if (con == null)
	         {
	             return "Error while connecting to the database";
	         }
	        
	        // create a prepared statement
	        String query = " insert into researcher(researcherCode, researcherName, projectCode, email, location)" + " values (?, ?, ?, ?, ?)";
	        PreparedStatement preparedStmt = con.prepareStatement(query);

	        // binding values
	        //preparedStmt.setInt(1, 0);
	        preparedStmt.setString(1, resCode);
	        preparedStmt.setString(2, resName);
	        preparedStmt.setString(3, resProjCode);
	        preparedStmt.setString(4, resEmail);
	        preparedStmt.setString(5, resLocation);
	        
	        

	        //execute the statement
	        preparedStmt.execute();
	        con.close();

	        output = "Inserted successfully";

		}catch(Exception e){

	        output = "Error while inserting";
	        System.err.println(e.getMessage());
		}

		return output;

	}
	
	
	
	public String readResearcher(){

		String output = "";
		try
		{
				Connection con = connect();
				if (con == null)
				{
					return "Error while connecting to the database for reading."; 
				}


				// Prepare the html table to be displayed
				output = "<table border=\"1\"><tr><th>Researcher Code</th><th>Researcher Name</th><th>Project Code</th><th>Email</th><th>Location</th><th>Update</th><th>Remove</th></tr>";
				String query = "select * from researcher";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				// iterate through the rows in the result set
				while (rs.next())
				{
					//'researcherID','researcherName','email','location','category'
					String researcherID = Integer.toString(rs.getInt("researcherID"));
					String researcherCode = rs.getString("researcherCode");
					String researcherName = rs.getString("researcherName");
					String projectCode = rs.getString("projectCode");
					String email = rs.getString("email");
					String location = rs.getString("location");
					

					// Add into the html table
					output += "<tr><td>" + researcherCode + "</td>";
					output += "<td>" + researcherName + "</td>";
					output += "<td>" + projectCode + "</td>";
					output += "<td>" + email + "</td>";
					output += "<td>" + location + "</td>";
					
					
					
					// buttons
					output += "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>"
					+ "<td><form method=\"post\" action=\"index.jsp\">"
					+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">"
					+ "<input name=\"itemID\" type=\"hidden\" value=\"" + researcherID
					+ "\">" + "</form></td></tr>";
				}

				con.close();
				// Complete the html table
				output += "</table>";
		}
		catch (Exception e)
		{
				output = "Error while reading the values.";
				System.err.println(e.getMessage());
		}
	return output;
}
	
	
	
	
	public String updateResearcher(String resID, String resCode, String resName,  String resProjCode, String resEmail, String resLocation){
	    
	    String output = "";

	    try{

	           Connection con = connect();
	           if (con == null){
	           return "Error while connecting to the database for updating.";
	           }
	           
	           // create a prepared statement

	           String query = "UPDATE researcher SET researcherCode=?,researcherName=?,projectCode=?,email=?,location=? WHERE researcherID=?";
	           PreparedStatement preparedStmt = con.prepareStatement(query);
	           //'researcherName','email','location','category'
	           preparedStmt.setString(1, resCode);
	           preparedStmt.setString(2, resName);
	           preparedStmt.setString(3, resProjCode);
	           preparedStmt.setString(4, resEmail);
	           preparedStmt.setString(5, resLocation);
	           preparedStmt.setInt(6, Integer.parseInt(resID));

	           // execute the statement
	           preparedStmt.execute();
	           con.close();

	           output = "Updated successfully";
	           


	        }catch(Exception e){
	        	output = "Error while updating the value.";
				System.err.println(e.getMessage());
	        }

	        return output;

	    }
	
	
	public String deleteResearcher(String resID){

		String output = "";

		try{

			Connection con = connect();
			if (con == null){

	         return "Error while connecting to the database for deleting.";
	        }

	        // create a prepared statement
	        String query = "delete from researcher where researcherID=?";
	        PreparedStatement preparedStmt = con.prepareStatement(query);
	        // binding values
	        preparedStmt.setInt(1, Integer.parseInt(resID));
	        // execute the statement
	        preparedStmt.execute();
	        con.close();

	        output = "Deleted successfully";


		}catch (Exception e){

			output = "Error while deleting the value.";
			System.err.println(e.getMessage());
		}

		return output;
	}
}
