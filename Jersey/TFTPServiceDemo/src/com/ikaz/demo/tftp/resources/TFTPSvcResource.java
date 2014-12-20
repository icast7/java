package com.ikaz.demo.tftp.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.ikaz.demo.tftp.dao.TFTPdao;
import com.ikaz.demo.tftp.model.TFTPFile;

/**
 * Maps the resource to the svc URL
 * @author icastillejos
 * @version 0.0.1
 */
@Path("/tftp")
public class TFTPSvcResource {
	//Allows inserting context objects in the class
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	//Return list of files
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<TFTPFile> getTodosBrowser(){
		List<TFTPFile> todos = new ArrayList<TFTPFile>();
		todos.addAll(TFTPdao.INSTANCE.getModel().values());
		return todos;		
	}	
	//List for files
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<TFTPFile> getTodos(){
		List<TFTPFile> todos = new ArrayList<TFTPFile>();
		todos.addAll(TFTPdao.INSTANCE.getModel().values());
		return todos;
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newTodo(
	@FormParam("id") String id, 
	@FormParam("filePath") String filePath,
	@Context HttpServletResponse servletResponse) throws IOException
	{
		TFTPFile todo = new TFTPFile(id, filePath);
		TFTPdao.INSTANCE.getModel().put(id, todo);
		servletResponse.sendRedirect("../create_file.html");
	}
	
	@Path("{file}")
	public TFTPResource getTodo(@PathParam("file") String id){
		return new TFTPResource(uriInfo, request, id);
	}
}
