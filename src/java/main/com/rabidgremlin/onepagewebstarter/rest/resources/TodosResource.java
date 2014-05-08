package com.rabidgremlin.onepagewebstarter.rest.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rabidgremlin.onepagewebstarter.doa.TodoDoa;
import com.rabidgremlin.onepagewebstarter.rest.dto.TodoCreateDto;
import com.rabidgremlin.onepagewebstarter.rest.dto.TodoDto;
import com.rabidgremlin.onepagewebstarter.rest.dto.TodoUpdateDto;

@Path("todos")
public class TodosResource {

	private TodoDoa todoDoa;

	@Inject
	public TodosResource(TodoDoa todoDoa) {
		this.todoDoa = todoDoa;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TodoDto> getTodos() {

		return todoDoa.getAll();
	}

	@DELETE
	@Path("{todoId}")
	public void deleteTodo(@PathParam("todoId") String todoId) {
		System.out.println("****************** Deleting:" + todoId);
		todoDoa.deleteTodo(todoId);
	}

	@PUT
	@Path("{todoId}")
	public void updateTodo(@PathParam("todoId") String todoId,
			TodoUpdateDto todoUpdate) {
		System.out.println("****************** Updating:" + todoId);

		TodoDto todo = todoDoa.getTodo(todoId);

		if (todoUpdate.getCompleted() != null) {
			todo.setCompleted(todoUpdate.getCompleted());
		}

		if (todoUpdate.getDescription() != null) {
			todo.setDescription(todoUpdate.getDescription());
		}
		
		todoDoa.saveTodo(todo);
	}
	
	@POST	
	public void updateTodo(
			TodoCreateDto todoCreate) {
		System.out.println("****************** Creating:" + todoCreate);

		TodoDto todo = new TodoDto();
		todo.setCompleted(false);
		todo.setDescription(todoCreate.getDescription());
		
		todoDoa.saveTodo(todo);
		
		//todo return 201
	}

}
