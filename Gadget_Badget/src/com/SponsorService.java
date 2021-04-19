package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Sponsor;



@Path("/Sponsors")

public class SponsorService {

	Sponsor itemObj = new Sponsor();
	

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	
	public String readItems() 
	{ 
		return itemObj.readItems(); 
	
	}
	
	
	
	
	
	

	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 

	public String insertItem(@FormParam("f_name") String f_name, 
						@FormParam("l_name") String l_name, 
						@FormParam("company") String company, 
						@FormParam("job") String job,
						@FormParam("phone") String phone,
						@FormParam("mail") String mail,
						@FormParam("city") String city) 
	{ 
	
		String output = itemObj.insertItem(f_name, l_name, company, job, phone, mail, city); 
		return output; 
 
	}









	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public String updateItem(String itemData)
	{

		JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();

		String buyer_id  = itemObject.get("buyer_id").getAsString();
		String f_name    = itemObject.get("f_name").getAsString();
		String l_name    = itemObject.get("l_name").getAsString();
		String company   = itemObject.get("company").getAsString();
		String job       = itemObject.get("job").getAsString();
		String phone     = itemObject.get("phone").getAsString();
		String mail      = itemObject.get("mail").getAsString();
		String city      = itemObject.get("city").getAsString();
 	
		String output    = itemObj.updateItem(buyer_id, f_name, l_name, company, job, phone, mail, city );
 
		return output;
		
}









	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)

	public String deleteItem(String itemData)
	{

		Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());

		String buyer_id = doc.select("buyer_id").text();
	
		String output = itemObj.deleteItem(buyer_id);
	
		return output;
	}



}
