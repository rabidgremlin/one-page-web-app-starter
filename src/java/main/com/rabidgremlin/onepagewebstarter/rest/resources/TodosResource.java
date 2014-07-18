/* 
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package com.rabidgremlin.onepagewebstarter.rest.resources;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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

import org.apache.commons.beanutils.PropertyUtils;

import com.google.inject.persist.Transactional;
import com.rabidgremlin.onepagewebstarter.doa.TodoDoa;
import com.rabidgremlin.onepagewebstarter.entity.Todo;
import com.rabidgremlin.onepagewebstarter.rest.dto.TodoCreateDto;
import com.rabidgremlin.onepagewebstarter.rest.dto.TodoDto;
import com.rabidgremlin.onepagewebstarter.rest.dto.TodoUpdateDto;
import com.rabidgremlin.onepagewebstarter.util.AppConfig;

@Path("todos")
public class TodosResource
{

  private TodoDoa todoDoa;
  private AppConfig appConfig;

  @Inject
  public TodosResource(AppConfig appConfig, TodoDoa todoDoa)
  {
	System.out.println("Created TodosResource. doa:" + todoDoa + " appConfig: " + appConfig);
	this.todoDoa = todoDoa;
	this.appConfig = appConfig;
  }

  @Transactional
  @DELETE
  @Path("{todoId}")
  public void deleteTodo(@PathParam("todoId") String todoId)
  {
	System.out.println("****************** Deleting:" + todoId);
	todoDoa.deleteTodo(todoId);
  }

  @Transactional
  @GET
  @Path("{todoId}")
  public TodoDto getTodo(@PathParam("todoId") String todoId)
  {
	System.out.println("****************** Getting:" + todoId);
	return makeDto(todoDoa.getTodo(todoId));
  }

  @Transactional
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<TodoDto> getTodos()
  {
	List<Todo> todos = todoDoa.getAll();

	List<TodoDto> todoDtos = new ArrayList<TodoDto>();

	for (Todo todo : todos)
	{
	  TodoDto temp = makeDto(todo);
	  todoDtos.add(temp);
	}

	return todoDtos;
  }

  private TodoDto makeDto(Todo todo)
  {
	TodoDto temp = new TodoDto();
	try
	{
	  PropertyUtils.copyProperties(temp, todo);
	}
	catch (IllegalAccessException e)
	{
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	}
	catch (InvocationTargetException e)
	{
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	}
	catch (NoSuchMethodException e)
	{
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	}
	return temp;
  }

  @Transactional
  @PUT
  @Path("{todoId}")
  public void updateTodo(@PathParam("todoId") String todoId, TodoUpdateDto todoUpdate)
  {
	System.out.println("****************** Updating:" + todoId);

	Todo todo = todoDoa.getTodo(todoId);

	if (todoUpdate.getCompleted() != null)
	{
	  todo.setCompleted(todoUpdate.getCompleted());
	}

	if (todoUpdate.getDescription() != null)
	{
	  todo.setDescription(todoUpdate.getDescription());
	}

	todoDoa.saveTodo(todo);
  }

  @Transactional
  @POST
  public void updateTodo(TodoCreateDto todoCreate)
  {
	System.out.println("****************** Creating:" + todoCreate);

	Todo todo = new Todo();
	todo.setCompleted(false);
	todo.setDescription(todoCreate.getDescription());

	todoDoa.saveTodo(todo);

	// todo return 201
  }

}
