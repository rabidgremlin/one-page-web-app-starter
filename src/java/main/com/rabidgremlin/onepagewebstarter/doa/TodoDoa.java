package com.rabidgremlin.onepagewebstarter.doa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.inject.Singleton;

import org.joda.time.DateTime;

import com.rabidgremlin.onepagewebstarter.rest.dto.TodoDto;

// temp hacky class
@Singleton
public class TodoDoa {

	ArrayList<TodoDto> todos = new ArrayList<TodoDto>();

	public TodoDoa() {
		todos.add(new TodoDto(UUID.randomUUID().toString(), "Buy some milk",
				false, new DateTime().minusMinutes(10)));
		todos.add(new TodoDto(UUID.randomUUID().toString(),
				"Pick up dry cleaning", false, new DateTime().minusMinutes(12)));
		todos.add(new TodoDto(UUID.randomUUID().toString(), "Put out trash",
				true, new DateTime().minusMinutes(13)));
	}

	public synchronized List<TodoDto> getAll() {
		return Collections.unmodifiableList(todos);
	}

	public synchronized TodoDto getTodo(String id) {
		for (TodoDto todo : todos) {
			if (todo.getId().equals(id)) {
				return todo;
			}
		}

		return null;
	}

	public synchronized boolean deleteTodo(String id) {
		TodoDto todo = getTodo(id);
		if (todo == null) {
			return false;
		}
		todos.remove(todo);
		return true;
	}

	public synchronized void saveTodo(TodoDto todo) {
		if (todo.getId() == null) {
			todo.setId(UUID.randomUUID().toString());
		}

		todo.setLastDateTimeModified(new DateTime());

		if (getTodo(todo.getId()) == null) {
			todos.add(todo);
		}
	}

}
