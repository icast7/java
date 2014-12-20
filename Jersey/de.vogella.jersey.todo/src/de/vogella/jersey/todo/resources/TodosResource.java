package de.vogella.jersey.todo.resources;

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

import de.vogella.jersey.todo.dao.TodoDao;
import de.vogella.jersey.todo.model.Todo;

//Will map the resource to the todos  URL
@Path("/todos")
public class TodosResource {
	//Allows inserting contextual objects into the class
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	//Return list of todos
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Todo> getTodosBrowser(){
		List<Todo> todos = new ArrayList<Todo>();
		todos.addAll(TodoDao.INSTANCE.getModel().values());
		return todos;		
	}	
	//List for applications
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Todo> getTodos(){
		List<Todo> todos = new ArrayList<Todo>();
		todos.addAll(TodoDao.INSTANCE.getModel().values());
		
		
		
		
		return todos;
	}
	
	//Return number of todos
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount(){
		int count = TodoDao.INSTANCE.getModel().size();
		return String.valueOf(count);
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newTodo(
	@FormParam("id") String id, 
	@FormParam("summary") String summary,
	@FormParam("description") String description,
	@Context HttpServletResponse servletResponse) throws IOException
	{
		Todo todo = new Todo(id, summary);
		if (description != null){
			todo.setDescription(description);
		}
		TodoDao.INSTANCE.getModel().put(id, todo);
		servletResponse.sendRedirect("../create_todo.html");
	}
	
	@Path("{todo}")
	public TodoResource getTodo(@PathParam("todo") String id){
		return new TodoResource(uriInfo, request, id);
	}
}
