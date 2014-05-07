package com.rabidgremlin.onepagewebstarter.rest.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rabidgremlin.onepagewebstarter.doa.TodoDoa;
import com.rabidgremlin.onepagewebstarter.rest.dto.TodoDto;

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

}
