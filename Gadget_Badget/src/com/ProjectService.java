package com;

import model.Project; 

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/Projects")
public class ProjectService {
	
	Project itemObj = new Project(); 

	//for reading the projects
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readItems() 
	 { 
	 return itemObj.readProducts(); 
	 }

	
	//for inserting projects
	
	 @POST
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String insertItem(@FormParam("project_code") String project_code,
		  @FormParam("project_category") String project_category,
		  @FormParam("project_name") String project_name,
		  @FormParam("project_descrip") String project_descrip,
		  @FormParam("project_price") String project_price,
		  @FormParam("no_of_projects") String no_of_projects)
		
		 {
		  String output = itemObj.insertProduct(project_code, project_category, project_name, project_descrip, project_price, no_of_projects);
		  return output;
	     }
	
	
	//for updating projects
	 
	 @PUT
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.TEXT_PLAIN)
	 public String updateProduct(String projectData)
	 {
		 
		 //Convert the input string to a JSON object
		  JsonObject projectObject = new JsonParser().parse(projectData).getAsJsonObject();
		  
		 //Read the values from the JSON object
		  String project_Id = projectObject.get("project_Id").getAsString();
		  String project_code = projectObject.get("project_code").getAsString();
		  String project_category = projectObject.get("project_category").getAsString();
		  String project_name = projectObject.get("project_name").getAsString();
		  String project_descrip = projectObject.get("project_descrip").getAsString();
		  String project_price = projectObject.get("project_price").getAsString();
		  String no_of_projects = projectObject.get("no_of_projects").getAsString();
		  
		  String output = itemObj.updateProduct(project_Id, project_code, project_category, project_name, project_descrip, project_price, no_of_projects);
		  return output;
	 }
	 
	
	 
	 //for deleting projects
	 
	 @DELETE
	 @Path("/") 
	 @Consumes(MediaType.APPLICATION_XML) 
	 @Produces(MediaType.TEXT_PLAIN) 
	 public String deleteProduct(String projectData) 
	 { 
		 
	 //Convert the input string to an XML document
	  Document doc = Jsoup.parse(projectData, "", Parser.xmlParser()); 
	  
	 //Read the value from the element <project_Id>
	  String project_Id = doc.select("project_Id").text();
	  String output = itemObj.deleteProduct(project_Id); 
	  return output; 
	 }
	 
	 
	 
	 
	 


	
	
}
