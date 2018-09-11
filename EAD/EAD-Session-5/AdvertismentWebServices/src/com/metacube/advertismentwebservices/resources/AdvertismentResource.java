package com.metacube.advertismentwebservices.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.metacube.advertismentwebservices.dao.AdvertisementDao;
import com.metacube.advertismentwebservices.entity.Advertisement;
import com.metacube.advertismentwebservices.enums.Status;
import com.metacube.advertismentwebservices.facade.AdvertisementFacade;
@Path("/AdvertisementResource")
public class AdvertismentResource {
	AdvertisementFacade advertismentFacade=AdvertisementFacade.getInstance();

	
	@POST
	@Path("/InsertAdvertisement")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertAdvertisement(@PathParam("name") String name, @PathParam("desc") String desc){
		if(name==null){
			
			return Response.serverError().entity("ID cannot be blank").build();
		
		}
		
		if(advertismentFacade.insertAdvertisement(name, desc) == Status.INSERTED){
		
			return Response.ok("Successfully Inserted", MediaType.APPLICATION_JSON).build();
		
		}
		
		else{
			
			return Response.status(Response.Status.CREATED).entity("Entity not Created").build();
		}	
	}

	@GET
	@Path("/GetAdvertisment")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAdvertisement() {
		List<Advertisement> advertismentList=advertismentFacade.getAll();
		if(advertismentList.size()==0){
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found ").build();
		}
		else{
			Gson gson = new Gson();
			String advertismnetJson=gson.toJson(advertismentList);
			return Response.ok(advertismnetJson, MediaType.APPLICATION_JSON).build();
		}
	}


	@GET
	@Path("/GetAdvertismentById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAdvertisementById(@PathParam("id") String id) {
		if(id==null || id.trim().length()==0){
			return Response.serverError().entity("ID cannot be blank").build();
		}
		List<Advertisement> advertismentList=advertismentFacade.getAllById(Integer.parseInt(id));
		if(advertismentList.size()==0){
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for Id: " + id).build();
		}
		else{
			Gson gson = new Gson();
			String advertismnetJson=gson.toJson(advertismentList);
			return Response.ok(advertismnetJson, MediaType.APPLICATION_JSON).build();
		}

	}

	@GET
	@Path("/UpdateAdvertisement/{id}/{title}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateAdvertisementName(@PathParam("id")String id,@PathParam("title") String title){
		if(id==null || title ==null ){
			return Response.serverError().entity("Input parameters cannot be blank").build();
		}
		if(advertismentFacade.updateName(title, Integer.parseInt(id)).equals(Status.UPDATED)){
			return Response.ok("Successfully updated", MediaType.TEXT_PLAIN).build();
		}
		else{
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for id: " + id).build();
		}
	}

	@DELETE
	@Path("/DeleteById/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteAdvertisementById(@PathParam("id") String id){
		if(id==null){
			return Response.serverError().entity("Input parameters cannot be blank").build();
		}
		if(advertismentFacade.deleteAdvertisementById(Integer.parseInt(id)).equals(Status.DELETED)){
			return Response.ok("Successfully Deleted", MediaType.TEXT_PLAIN).build();
		}
		else{
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for id: " + id).build();
		}
		
	}

}
