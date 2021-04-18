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

//	@GET
//	@Path("/") 
//	@Produces(MediaType.TEXT_HTML) 
//	public String readItems() 
//	 { 
//	 return "Hello"; 
//	 } 
	
//	@GET
//	@Path("/") 
//	@Produces(MediaType.TEXT_HTML) 
//	public String readItems() 
//	 { 
//	 return itemObj.readProducts(); 
//	 }
	
//	 @POST
//	 @Path("/")
//	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	 @Produces(MediaType.TEXT_PLAIN)
//	 public String insertItem(@FormParam("project_code") String pro_code,
//		  @FormParam("project_category") String pro_category,
//		  @FormParam("project_name") String pro_name,
//		  @FormParam("project_descrip") String pro_desc,
//		  @FormParam("project_price") String pro_price,
//		  @FormParam("no_of_projects") String pro_count)
//		
//		 {
//		  String output = itemObj.insertProduct(pro_code, pro_category, pro_name, pro_desc, pro_price, pro_count);
//		 return output;
//	 }
	 
	 
	 @DELETE
	 @Path("/") 
	 @Consumes(MediaType.APPLICATION_XML) 
	 @Produces(MediaType.TEXT_PLAIN) 
	 public String deleteProduct(String itemData) 
	 { 
	 //Convert the input string to an XML document
	  Document doc = Jsoup.parse(itemData, "", Parser.xmlParser()); 
	  
	 //Read the value from the element <itemID>
	  String project_Id = doc.select("project_Id").text(); 
	  String output = itemObj.deleteProduct(project_Id); 
	 return output; 
	 }

	
	
}
