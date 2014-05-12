package com.rabidgremlin.onepagewebstarter.doa;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.google.inject.Provider;
import com.rabidgremlin.onepagewebstarter.entity.Todo;

public class TodoDoa {
	private Provider<EntityManager> emProvider;

	@Inject
	public TodoDoa(Provider<EntityManager> emProvider) {
		System.out.println("Created DOA. em:" + emProvider);
		this.emProvider = emProvider;
	}

	private EntityManager getEntityManager() {
		return emProvider.get();
	}

	public List<Todo> getAll() {
		return getEntityManager().createQuery("SELECT t FROM Todo t",
				Todo.class).getResultList();
	}

	public Todo getTodo(String id) {

		return getEntityManager().find(Todo.class, id);
	}

	public boolean deleteTodo(String id) {
		getEntityManager().remove(getTodo(id));

		return true;
	}

	public void saveTodo(Todo todo) {

		if (todo.getId() == null) {
			todo.setId(UUID.randomUUID().toString());
		}

		getEntityManager().persist(todo);

	}
}
