package com.ikaz.demo.tftp.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import com.ikaz.demo.tftp.dao.TFTPdao;
import com.ikaz.demo.tftp.model.TFTPFile;

/**
 * This is a single file resource
 * @author icastillejos
 * @version 0.0.1
 */
public class TFTPResource {
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	String id;	
	public TFTPResource(UriInfo uriInfo, Request request, String id){
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}
	
	//Application Integration
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public TFTPFile getTodo(){
		TFTPFile todo = TFTPdao.INSTANCE.getModel().get(id);
		if (todo==null)
			throw new RuntimeException("Get: Todo with " + id + " not found");
		return todo;
	}

	//Browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public TFTPFile getTodoHTML(){
		TFTPFile todo = TFTPdao.INSTANCE.getModel().get(id);
		if (todo==null)
			throw new RuntimeException("Get: Todo with " + id + "not found");
		return todo;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putTodo(JAXBElement<TFTPFile> todo){
		TFTPFile c= todo.getValue();
		return putAndGetResponse(c);
	}

	private Response putAndGetResponse(TFTPFile tftpFile) {
		Response res;
		if (TFTPdao.INSTANCE.getModel().containsKey(tftpFile.getId())){
			res = Response.noContent().build();			
		} else {
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}
		TFTPdao.INSTANCE.getModel().put(tftpFile.getId(), tftpFile);
		return res;
	}
}

